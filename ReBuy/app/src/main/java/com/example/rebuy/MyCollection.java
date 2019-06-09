package com.example.rebuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCollection extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private AuctionAdapter adapter;
    private List<AuctionCloth> mClothList;
    private TextView price;
    private TextView person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        TextView libel = (TextView) findViewById(R.id.lible);
        libel.setText("我的收藏");
        recyclerView =  (RecyclerView) findViewById(R.id.mycollection_recyclerview);
        price = (TextView) findViewById(R.id.price);
        person = (TextView) findViewById(R.id.person);
        mClothList = new ArrayList<>();
        inite();
        adapter = new AuctionAdapter(mClothList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    private void inite(){
        mClothList.clear();
        for(int i = 0 ;i<20;i++){
            Random random = new Random();
            String price = String.valueOf(random.nextInt(1000));
            String person = String.valueOf(random.nextInt(100));
            mClothList.add(new AuctionCloth(price, person));
        }
    }

}
