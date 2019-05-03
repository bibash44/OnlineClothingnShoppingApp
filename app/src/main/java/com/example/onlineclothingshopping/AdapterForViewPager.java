package com.example.onlineclothingshopping;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterForViewPager extends FragmentPagerAdapter {

    private List<Fragment> listOfFragment = new ArrayList<>();
    private List<String> titleOfFragment = new ArrayList<>();


    public AdapterForViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return listOfFragment.get(i);
    }

    @Override
    public int getCount() {
        return listOfFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleOfFragment.get(position);
    }

    public void addFragments(Fragment fragment, String title) {
    listOfFragment.add(fragment);
    titleOfFragment.add(title);
    }
}
