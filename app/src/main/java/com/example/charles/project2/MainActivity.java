package com.example.charles.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Featured"));
        tabLayout.addTab(tabLayout.newTab().setText("Recipes"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
}
