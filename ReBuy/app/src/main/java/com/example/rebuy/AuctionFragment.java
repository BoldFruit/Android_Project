package com.example.rebuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2019/6/1.
 */

public class AuctionFragment extends Fragment {
    private List<AuctionCloth> mClothList;
    private TextView price;
    private TextView person;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AuctionAdapter adapter;
    public AuctionFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_auction, container, false);
        price = (TextView) view.findViewById(R.id.price);
        person = (TextView) view.findViewById(R.id.person);
        mClothList = new ArrayList<>();
        inite();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.auction_recyclerview);
        adapter = new AuctionAdapter(mClothList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                refreshCloth();
            }
        });
        return view;
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

    private void refreshCloth(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        inite();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}
