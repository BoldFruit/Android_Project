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

public class MyStoreFragment1 extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyStoreFragment1.MystoreAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.store_view1, container, false);
        recyclerView =  view.findViewById(R.id.store_recycler1);
        adapter = new MyStoreFragment1.MystoreAdapter();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public class MystoreAdapter extends RecyclerView.Adapter<MystoreAdapter.ViewHolder> {

         class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View view){
                super(view);
            }
        }

        public MystoreAdapter(){}
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_recyclerview_item1, parent, false);
            MystoreAdapter.ViewHolder holder = new MystoreAdapter.ViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(MystoreAdapter.ViewHolder holder, int position){
        }
        @Override
        public int getItemCount(){
            return 20;
        }
    }
}
