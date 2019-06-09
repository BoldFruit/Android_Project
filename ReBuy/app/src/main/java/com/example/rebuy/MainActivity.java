package com.example.rebuy;

import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener {
    public static final int FIRSTPAGE = 0;
    public static final int AUCTION = 1;
    public static final int MESSAGE = 2;
    public static final int MINE = 3;

    public static ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private LinearLayout firstPage;
    private LinearLayout auction;
    private LinearLayout message;
    private LinearLayout mine;
    private int lastPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstPage = (LinearLayout) findViewById(R.id.firstpage_item);
        auction = (LinearLayout) findViewById(R.id.auction_item);
        message = (LinearLayout) findViewById(R.id.message_item);
        mine = (LinearLayout) findViewById(R.id.mine_item);
        firstPage.setOnClickListener(this);
        auction.setOnClickListener(this);
        message.setOnClickListener(this);
        mine.setOnClickListener(this);
        viewPager = (ViewPager) findViewById(R.id.fragment_pager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(FIRSTPAGE);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (lastPosition){
            case FIRSTPAGE:
                TextView text = (TextView) findViewById(R.id.firstpage_text);
                ImageView img = (ImageView) findViewById(R.id.firstpage_icon);
                text.setTextColor(getResources().getColor(R.color.gray));
                img.setImageResource(R.drawable.firstpage);
                break;
            case AUCTION:
                TextView text1 = (TextView) findViewById(R.id.auction_text);
                ImageView img1 = (ImageView) findViewById(R.id.auction_icon);
                text1.setTextColor(getResources().getColor(R.color.gray));
                img1.setImageResource(R.drawable.auction);
                break;
            case MESSAGE:
                TextView text2 = (TextView) findViewById(R.id.message_text);
                ImageView img2 = (ImageView) findViewById(R.id.message_icon);
                text2.setTextColor(getResources().getColor(R.color.gray));
                img2.setImageResource(R.drawable.message);
                break;
            case MINE:
                TextView text3 = (TextView) findViewById(R.id.mine_text);
                ImageView img3 = (ImageView) findViewById(R.id.mine_icon1);
                text3.setTextColor(getResources().getColor(R.color.gray));
                img3.setImageResource(R.drawable.mine);
                break;
            default:
                break;
        }
        switch (position){
            case FIRSTPAGE:
                TextView text = (TextView) findViewById(R.id.firstpage_text);
                ImageView img = (ImageView) findViewById(R.id.firstpage_icon);
                text.setTextColor(getResources().getColor(R.color.blue));
                img.setImageResource(R.drawable.firstpage_fill);
                break;
            case AUCTION:
                TextView text1 = (TextView) findViewById(R.id.auction_text);
                ImageView img1 = (ImageView) findViewById(R.id.auction_icon);
                text1.setTextColor(getResources().getColor(R.color.blue));
                img1.setImageResource(R.drawable.auction_fill);
                break;
            case MESSAGE:
                TextView text2 = (TextView) findViewById(R.id.message_text);
                ImageView img2 = (ImageView) findViewById(R.id.message_icon);
                text2.setTextColor(getResources().getColor(R.color.blue));
                img2.setImageResource(R.drawable.message_fill);
                break;
            case MINE:
                TextView text3 = (TextView) findViewById(R.id.mine_text);
                ImageView img3 = (ImageView) findViewById(R.id.mine_icon1);
                text3.setTextColor(getResources().getColor(R.color.blue));
                img3.setImageResource(R.drawable.mine_fill);
                break;
            default:
                break;
        }
        lastPosition = position;
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.firstpage_item:
                viewPager.setCurrentItem(FIRSTPAGE);
                break;
            case R.id.auction_item:
                viewPager.setCurrentItem(AUCTION);
                break;
            case R.id.message_item:
                viewPager.setCurrentItem(MESSAGE);
                break;
            case R.id.mine_item:
                viewPager.setCurrentItem(MINE);
                break;
            default:
                break;
        }
    }

}
