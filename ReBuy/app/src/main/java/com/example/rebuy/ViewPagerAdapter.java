package com.example.rebuy;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/5/31.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViewList;
    ViewPagerAdapter(List<ImageView> imageViewList){
        this.imageViewList = imageViewList;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView(imageViewList.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        container.addView(imageViewList.get(position));
        return imageViewList.get(position);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageViewList.size();
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }
}
