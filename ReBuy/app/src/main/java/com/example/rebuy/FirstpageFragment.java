package com.example.rebuy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2019/6/1.
 */

public class FirstpageFragment extends Fragment {
    public FirstpageFragment(){}
    private List<ImageView> imageViewList;
    private List<View> dotList;
    private int prePosition;
    private int curPosition;

    private ViewPager imageViewPager;
    private ViewPagerAdapter imageViewPagerAdapter;
    private ScheduledExecutorService scheduledExecutorService;

    private List<FirstpageClothes> firstpageClothesList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_firstpage, container, false);
        initRecycler();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_firstpage);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FirstpageClothesAdapter adapter = new FirstpageClothesAdapter(firstpageClothesList);
        recyclerView.setAdapter(adapter);
        
        imageViewList = new ArrayList<ImageView>();
        imageViewList.add(CreateImageView(R.drawable.pager_1));
        imageViewList.add(CreateImageView(R.drawable.pager_2));
        imageViewList.add(CreateImageView(R.drawable.pager_3));
        imageViewList.add(CreateImageView(R.drawable.pager_4));
        imageViewList.add(CreateImageView(R.drawable.pager_5));

        dotList = new ArrayList<View>();
        dotList.add(view.findViewById(R.id.dot_0));
        dotList.add(view.findViewById(R.id.dot_1));
        dotList.add(view.findViewById(R.id.dot_2));
        dotList.add(view.findViewById(R.id.dot_3));
        dotList.add(view.findViewById(R.id.dot_4));

        dotList.get(0).setBackgroundResource(R.drawable.dot_focused);
        imageViewPager = (ViewPager) view.findViewById(R.id.imageViewPager);
        imageViewPagerAdapter = new ViewPagerAdapter(imageViewList);
        imageViewPager.setAdapter(imageViewPagerAdapter);
        imageViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                dotList.get(prePosition).setBackgroundResource(R.drawable.dot_normal);
                dotList.get(position).setBackgroundResource(R.drawable.dot_focused);
                prePosition = position;
                curPosition = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
    private void initRecycler(){
        for(int i = 0; i<2; i++){
            FirstpageClothes cloth1 = new FirstpageClothes(102, true, true, true, false);
            firstpageClothesList.add(cloth1);
            FirstpageClothes cloth2 = new FirstpageClothes(302.1, true, false, true, false);
            firstpageClothesList.add(cloth2);
            FirstpageClothes cloth3 = new FirstpageClothes(202.1, true, false, true, false);
            firstpageClothesList.add(cloth3);
            FirstpageClothes cloth4 = new FirstpageClothes(209.5, false, false, true, false);
            firstpageClothesList.add(cloth4);
            FirstpageClothes cloth5 = new FirstpageClothes(308.1, false, false, false, false);
            firstpageClothesList.add(cloth5);
            FirstpageClothes cloth6 = new FirstpageClothes(302.1, true, false, true, false);
            firstpageClothesList.add(cloth6);
            FirstpageClothes cloth7 = new FirstpageClothes(302.1, true, false, false, false);
            firstpageClothesList.add(cloth7);
            FirstpageClothes cloth8 = new FirstpageClothes(890, false, false, true, false);
            firstpageClothesList.add(cloth8);
            FirstpageClothes cloth9 = new FirstpageClothes(988, true, false, true, false);
            firstpageClothesList.add(cloth9);
            FirstpageClothes cloth10 = new FirstpageClothes(2093, true, false, true, false);
            firstpageClothesList.add(cloth10);
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ScrollImageTask(), 2, 2, TimeUnit.SECONDS);
    }
    Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            imageViewPager.setCurrentItem(curPosition);
        }
    };
    private ImageView CreateImageView(int resourceId){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(resourceId);
        return imageView;
    }

    private class ScrollImageTask implements Runnable{
        @Override
        public void run(){
            curPosition = (curPosition + 1)% imageViewList.size();
            hander.obtainMessage().sendToTarget();
        }
    }
}
