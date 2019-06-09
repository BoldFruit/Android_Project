package com.example.rebuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2019/6/7.
 */

public class MyOrderFragment1 extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyOrderFragment1.MyOrderAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.order_view1, container, false);
        recyclerView =  view.findViewById(R.id.order_recycler1);
        adapter = new MyOrderFragment1.MyOrderAdapter();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderFragment1.MyOrderAdapter.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View view){
                super(view);
            }
        }

        public MyOrderAdapter(){}
        @Override
        public MyOrderFragment1.MyOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_item1, parent, false);
            MyOrderFragment1.MyOrderAdapter.ViewHolder holder = new MyOrderFragment1.MyOrderAdapter.ViewHolder (view);
            return holder;
        }
        @Override
        public void onBindViewHolder(MyOrderFragment1.MyOrderAdapter.ViewHolder holder, int position){
        }
        @Override
        public int getItemCount(){
            return 20;
        }
}
}
