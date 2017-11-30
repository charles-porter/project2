package com.example.charles.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.SyncConfiguration;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

public class MainActivity extends AppCompatActivity {

    public Realm realm;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        login("cs188","MyBeautifulBulldogApp");
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        user = realm.where(User.class).equalTo("username", getIntent().getStringExtra("username")).findFirst();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Recipe Add", Snackbar.LENGTH_LONG);

                Intent intent = new Intent(getBaseContext(), RecipeAdd.class);
                startActivity(intent);

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Favorite"));
        tabLayout.addTab(tabLayout.newTab().setText("Search"));
        tabLayout.addTab(tabLayout.newTab().setText("Grocery"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PagerAdapter adapter = new com.example.charles.project2.PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void login(final String username, final String password) {
//        if(SyncUser.currentUser() != null) {
//
//            Realm realm = Realm.getDefaultInstance();
//            if(realm != null) {
//                realm.close();
//                Realm.deleteRealm(realm.getConfiguration());
//            }
//
//            SyncUser.currentUser().logout();
//        }

        SyncCredentials myCredentials = SyncCredentials.usernamePassword(username, password, false);
        SyncUser.loginAsync(myCredentials, "http://52.205.194.154:9080", new SyncUser.Callback() {
            @Override
            public void onSuccess(SyncUser user) {
                SyncConfiguration configuration = new SyncConfiguration
                        .Builder(user, "http://52.205.194.154:9080/~/CollegeEats_v1")
                        .disableSSLVerification().waitForInitialRemoteData().schemaVersion((long) 1.0).build();
                Realm.setDefaultConfiguration(configuration);

                Realm.getInstanceAsync(configuration, new Realm.Callback() {
                    @Override
                    public void onSuccess(Realm realm) {

                        //successfully created a user
                        final User user = new User();
                        user.setUsername("default");
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.copyToRealmOrUpdate(user);

                            }
                        });

                        realm.close();
                    }
                });
            }

            @Override
            public void onError(ObjectServerError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
    }
}
