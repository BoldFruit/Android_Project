package com.example.rebuy;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.codes;
import static android.R.attr.onClick;
import static android.R.attr.targetActivity;

/**
 * Created by dell on 2019/6/2.
 */

public class FirstpageClothesAdapter extends RecyclerView.Adapter<FirstpageClothesAdapter.ViewHolder> {
    private List<FirstpageClothes> fClothesList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView isAuction;
        TextView isExchangable;
        TextView isNoBargain;
        TextView price;
        ImageView isLove;
        View clothesView;

        public ViewHolder(View view){
            super(view);
            isAuction = (TextView) view.findViewById(R.id.isAuction);
            isExchangable = (TextView) view.findViewById(R.id.isExchangable);
            isNoBargain = (TextView) view.findViewById(R.id.isNoBargain);
            price = (TextView) view.findViewById(R.id.price);
            isLove = (ImageView) view.findViewById(R.id.firstpage_love);
            clothesView = view;
        }
    }

    public FirstpageClothesAdapter(List<FirstpageClothes> ClothesList){
        fClothesList = ClothesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstpage_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.clothesView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int Position){
        final FirstpageClothes clothes = fClothesList.get(Position);
        holder.isLove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!clothes.getLoved()){
                    holder.isLove.setImageResource(R.drawable.love_fill);
                    clothes.setLove(true);
                }else{
                    holder.isLove.setImageResource(R.drawable.love);
                    clothes.setLove(false);
                }
            }
        });
        if(clothes.getAuction()){
            holder.isAuction.setVisibility(View.VISIBLE);
        }
        if(clothes.getExchangable()){
            holder.isExchangable.setVisibility(View.VISIBLE);
        }
        if(clothes.getNoBargain()){
            holder.isNoBargain.setVisibility(View.VISIBLE);
        }
        holder.price.setText(String.valueOf(clothes.getPrice()));
    }

    @Override
    public int getItemCount(){
        return fClothesList.size();
    }
}
