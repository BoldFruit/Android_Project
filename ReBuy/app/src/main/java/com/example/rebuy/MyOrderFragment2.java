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

public class MyOrderFragment2 extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyOrderFragment2.MyOrderAdapter2 adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.order_view2, container, false);
        recyclerView =  view.findViewById(R.id.order_recycler2);
        adapter = new MyOrderFragment2.MyOrderAdapter2();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public class MyOrderAdapter2 extends RecyclerView.Adapter<MyOrderFragment2.MyOrderAdapter2.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View view){
                super(view);
            }
        }

        public MyOrderAdapter2(){}
        @Override
        public MyOrderFragment2.MyOrderAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_item2, parent, false);
            MyOrderFragment2.MyOrderAdapter2.ViewHolder holder = new MyOrderFragment2.MyOrderAdapter2.ViewHolder (view);
            return holder;
        }
        @Override
        public void onBindViewHolder(MyOrderFragment2.MyOrderAdapter2.ViewHolder holder, int position){
        }
        @Override
        public int getItemCount(){
            return 20;
        }
    }
}
