package com.jiahaoliuliu.arabicviewpagersample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] fragmentsName;

    public ViewPagerAdapter(FragmentManager fm, Context context, String[] fragmentsName) {
        super(fm);
        this.context = context;
        this.fragmentsName = fragmentsName;
    }

    @Override
    public Fragment getItem(int i) {
        return ContentFragment.newInstance(fragmentsName[i]);
    }

    @Override
    public int getCount() {
        return fragmentsName.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsName[position];
    }
}
