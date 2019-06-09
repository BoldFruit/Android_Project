package com.example.rebuy;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyStoreActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private ViewPager vpager;
    private TextView tv_one;
    private TextView tv_two;
    private View v1;
    private View v2;
    private StorePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
        initViews();
        TextView libel = (TextView) findViewById(R.id.lible);
        libel.setText("我的小店");
    }

    private void initViews(){
        tv_one = (TextView) findViewById(R.id.tv_1);
        tv_two = (TextView) findViewById(R.id.tv_2);
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        v1 =  findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        pagerAdapter = new StorePagerAdapter(getSupportFragmentManager());
        vpager = (ViewPager) findViewById(R.id.vpager_store);
        vpager.setAdapter(pagerAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);

        }
    @Override
    public void onClick(View v){
        TextPaint tp1 = tv_one.getPaint();
        TextPaint tp2 = tv_two.getPaint();
        switch (v.getId()){
            case R.id.tv_1:
                vpager.setCurrentItem(0);
                tp1.setFakeBoldText(true);
                tp2.setFakeBoldText(false);
                break;
            case R.id.tv_2:
                vpager.setCurrentItem(1);
                tp1.setFakeBoldText(false);
                tp2.setFakeBoldText(true);
                break;
        }
    }

    @Override
    public void onPageSelected(int index) {
        switch(index){
            case 0:
                v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                v1.setVisibility(View.INVISIBLE);
                v2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }
}

