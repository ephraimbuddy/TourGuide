package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;


    public CategoryFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionsFragment();
        }
        else if (position == 1){
           return new HotelsFragment();
        }
        else if (position == 2){
            return new EatriesFragment();
        }
        else {
            return new HospitalsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String[] tabTitles = mContext.getResources().getStringArray(R.array.tabarray);
        return tabTitles[position];
    }
}
