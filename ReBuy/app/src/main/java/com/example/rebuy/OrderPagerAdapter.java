package com.example.rebuy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by dell on 2019/6/7.
 */

public class OrderPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 2;
    private MyOrderFragment1 myFragment1 = null;
    private MyOrderFragment2 myFragment2 = null;

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyOrderFragment1();
        myFragment2 = new MyOrderFragment2();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = myFragment1;
                break;
            case 1:
                fragment = myFragment2;
                break;
        }
        return fragment;
    }
}
