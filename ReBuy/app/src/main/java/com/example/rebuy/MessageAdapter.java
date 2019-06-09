package com.example.rebuy;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2019/6/8.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> messageList;
    public MessageAdapter(List<Message> list){
        messageList = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView operate;
        TextView time;
        LinearLayout message;

        public ViewHolder(View v){
            super(v);
            imageView = (ImageView)v.findViewById(R.id.cartoon1);
            name =  (TextView)v.findViewById(R.id.name);
            operate = (TextView)v.findViewById(R.id.operate);
            time = (TextView)v.findViewById(R.id.time);
            message = (LinearLayout)v.findViewById(R.id.message);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int  viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        final Message message = messageList.get(position);
        holder.message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = message.getName();
                String time = message.getTime();
                int ImageId = message.getImageId();
                MessageDetailActivity.actionStart(v.getContext(), ImageId, name, time);
            }
        });
        holder.operate.setText(message.getOperate());
        holder.name.setText(message.getName());
        holder.imageView.setImageResource(message.getImageId());
        holder.time.setText(message.getTime());
    }
    @Override
    public int getItemCount(){
        return messageList.size();
    }
}
