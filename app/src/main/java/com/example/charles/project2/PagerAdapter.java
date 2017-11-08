package com.example.charles.project2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Tyler Hopkins on 11/8/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    FavoriteFragment tab1 = new FavoriteFragment();
                    return tab1;
                case 1:
                    SearchFragment tab2 = new SearchFragment();
                    return tab2;
                case 2:
                    GroceryFragment tab3 = new GroceryFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
}
