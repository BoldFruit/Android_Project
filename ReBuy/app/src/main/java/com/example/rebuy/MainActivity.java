package com.example.rebuy;

import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private List<ImageView> imageViewList;
    private List<View> dotList;
    private int prePosition;
    private int curPosition;

    private ViewPager imageViewPager;
    private ViewPagerAdapter imageViewPagerAdapter;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
    }
    @Override
    public void onStart(){
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ScollImageTask(), 2, 2, TimeUnit.SECONDS);
    }
    Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            imageViewPager.setCurrentItem(curPosition);
        }
    };
    private void initView(){
        imageViewList = new ArrayList<ImageView>();
        imageViewList.add(CreateImageView(R.drawable.pager_1));
        imageViewList.add(CreateImageView(R.drawable.pager_2));
        imageViewList.add(CreateImageView(R.drawable.pager_3));
        imageViewList.add(CreateImageView(R.drawable.pager_4));
        imageViewList.add(CreateImageView(R.drawable.pager_5));

        dotList = new ArrayList<View>();
        dotList.add(findViewById(R.id.dot_0));
        dotList.add(findViewById(R.id.dot_1));
        dotList.add(findViewById(R.id.dot_2));
        dotList.add(findViewById(R.id.dot_3));
        dotList.add(findViewById(R.id.dot_4));

        dotList.get(0).setBackgroundResource(R.drawable.dot_focused);
        imageViewPager = (ViewPager) findViewById(R.id.imageViewPager);
    }

    private ImageView CreateImageView(int resourceId){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(resourceId);
        return imageView;
    }

    private class ScollImageTask implements Runnable{
        @Override
        public void run(){
            curPosition = (curPosition + 1)% imageViewList.size();
            hander.obtainMessage().sendToTarget();
        }
    }
}
