package com.example.rebuy;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.BoolRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2019/6/7.
 */

public class AuctionAdapter extends RecyclerView.Adapter<AuctionAdapter.ViewHolder> {
    private Context mcontext;
    private List<AuctionCloth> mClothList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView isLove;
        TextView person;
        TextView price;
        View v;

        public ViewHolder(View v){
            super(v);
            isLove = (ImageView) v.findViewById(R.id.islove);
            person = (TextView) v.findViewById(R.id.person);
            price = (TextView) v.findViewById(R.id.price);
            this.v =v;
        }
    }

    public AuctionAdapter(List<AuctionCloth> clothList ){
        mClothList = clothList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mcontext == null){
            mcontext = parent.getContext();
        }
        View view= LayoutInflater.from(mcontext).inflate(R.layout.auction_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),DetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        viewHolder.isLove.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = viewHolder.getAdapterPosition();
                AuctionCloth cloth = mClothList.get(position);
                if(!cloth.isLove){
                    cloth.setLove(true);
                    viewHolder.isLove.setImageResource(R.drawable.love_fill);
                }else{
                    cloth.setLove(false);
                    viewHolder.isLove.setImageResource(R.drawable.love);}
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        AuctionCloth cloth = mClothList.get(position);
        holder.price.setText("$"+cloth.getPrice());
        holder.person.setText("参与人数:"+cloth.getPerson());
        if(!cloth.isLove){
            holder.isLove.setImageResource(R.drawable.love);
        }else{
            holder.isLove.setImageResource(R.drawable.love_fill);
        }
    }

    @Override
    public int getItemCount(){
        return mClothList.size();
    }
}
