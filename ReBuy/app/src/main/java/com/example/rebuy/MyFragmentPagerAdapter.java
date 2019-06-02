package com.example.rebuy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by dell on 2019/6/1.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private FirstpageFragment firstpageFragment = null;
    private AuctionFragment auctionFragment = null;
    private MessageFragment messageFragment = null;
    private MineFragment mineFragment = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        firstpageFragment = new FirstpageFragment();
        auctionFragment = new AuctionFragment();
        messageFragment = new MessageFragment();
        mineFragment = new MineFragment();
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
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.FIRSTPAGE:
                fragment = firstpageFragment;
                break;
            case MainActivity.AUCTION:
                fragment = auctionFragment;
                break;
            case MainActivity.MESSAGE:
                fragment = messageFragment;
                break;
            case MainActivity.MINE:
                fragment = mineFragment;
                break;
        }
        return fragment;
    }

}
