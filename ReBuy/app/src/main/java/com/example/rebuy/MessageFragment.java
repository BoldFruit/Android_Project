package com.example.rebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2019/6/1.
 */

public class MessageFragment extends Fragment {
    public MessageFragment(){}
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Message> messageList = new ArrayList<>();
    private MessageAdapter adapter;
    private RecyclerView recyclerView;
    private Message[] messages = {new Message(R.drawable.cartoon1,"大果子","取消订单","2016.03.03   18.22"),new Message(R.drawable.cartoon2,"小果子","申请退款","2019.03.03   19.22")};
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_message, container, false);
        inite();
        adapter = new MessageAdapter(messageList);
        recyclerView = (RecyclerView) view.findViewById(R.id.message_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                refresh();
            }
        });
        return view;
    }
    private void inite(){
        messageList.clear();
        Random random = new Random();
        for(int i=0; i<2;i++){
            int index = random.nextInt(messages.length);
            messageList.add(messages[index]);
        }

    }
    private void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
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
