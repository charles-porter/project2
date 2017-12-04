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

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    protected ArrayList <Recipe> recipies = new ArrayList<Recipe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipies.add(new Recipe("Cheese", "Good Cheese", Arrays.asList("Cheese Mexican Tortalini".split("\\s+")), Arrays.asList("Bowl Heat Magic".split("\\s+")), 20));
        recipies.add(new Recipe("test", "testing", Arrays.asList("Code Working Please".split("\\s+")), Arrays.asList("Computer Miracle".split("\\s+")), 200));
        recipies.add(new Recipe("null", "null", Arrays.asList("null".split("\\s+")), Arrays.asList("null".split("\\s+")), 2000));
        recipies.add(new Recipe("Cooking App", "this", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("Look", "cool", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 89));
        recipies.add(new Recipe("At", "things", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 1));
        recipies.add(new Recipe("This", "are", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 91));
        recipies.add(new Recipe("App", "around", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9));
        recipies.add(new Recipe("Man", "the", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 901));
        recipies.add(new Recipe("Cool", "corner", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), .007));


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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
    }
}
