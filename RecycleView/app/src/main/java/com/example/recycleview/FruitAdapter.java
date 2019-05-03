package com.example.recycleview;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.recycleview.R.styleable.RecyclerView;

/**
 * Created by dell on 2019/4/24.
 */

public class FruitAdapter extends android.support.v7.widget.RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView ;
        TextView fruitName;
        ImageView fruitImage;
        ViewHolder(View view){
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
    FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = viewHolder.getAdapterPosition();
                Fruit fruit  = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }
    @Override
    public int getItemCount(){
        return mFruitList.size();
    }

}
