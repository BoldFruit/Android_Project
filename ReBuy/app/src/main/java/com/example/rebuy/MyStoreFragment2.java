package com.example.rebuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2019/6/7.
 */

public class MyStoreFragment2 extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyStoreFragment2.MystoreAdapter2 adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.store_view2, container, false);
        recyclerView =  view.findViewById(R.id.store_recycler2);
        adapter = new MystoreAdapter2();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public class MystoreAdapter2 extends RecyclerView.Adapter<MystoreAdapter2.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View view){
                super(view);
            }
        }

        public MystoreAdapter2(){}
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_recyclerview_item2, parent, false);
            MystoreAdapter2.ViewHolder holder = new MystoreAdapter2.ViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(MystoreAdapter2.ViewHolder holder, int position){
        }
        @Override
        public int getItemCount(){
            return 20;
        }
    }
}
