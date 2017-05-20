package com.spotasapdesign.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.spotasapdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh on 19/05/17.
 */

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();

    private Context mContext;

    public CategoryPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return mContext.getString(R.string.video);
        else if (position == 1)
            return mContext.getString(R.string.images);
        else
            return mContext.getString(R.string.milestone);
    }
}
