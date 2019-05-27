package com.example.rebuy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dell on 2019/5/24.
 */

public class MenuLayout extends LinearLayout implements View.OnClickListener {
    public MenuLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_menu, this);
        if(context.getClass() == MainActivity.class){
            TextView text = (TextView) findViewById(R.id.firstpage_text);
            ImageView img = (ImageView) findViewById(R.id.firstpage_icon);
            text.setTextColor(getResources().getColor(R.color.blue));
            img.setImageResource(R.drawable.firstpage_fill);
        }else if(context.getClass() == AuctionActivity.class){
            TextView text = (TextView) findViewById(R.id.auction_text);
            ImageView img = (ImageView) findViewById(R.id.auction_icon);
            text.setTextColor(getResources().getColor(R.color.blue));
            img.setImageResource(R.drawable.auction_fill);
        }else if(context.getClass() == MessageActivity.class){
            TextView text = (TextView) findViewById(R.id.message_text);
            ImageView img = (ImageView) findViewById(R.id.message_icon);
            text.setTextColor(getResources().getColor(R.color.blue));
            img.setImageResource(R.drawable.message_fill);
        }else if(context.getClass() == MineActivity.class){
            TextView text = (TextView) findViewById(R.id.mine_text);
            ImageView img = (ImageView) findViewById(R.id.mine_icon);
            text.setTextColor(getResources().getColor(R.color.blue));
            img.setImageResource(R.drawable.mine_fill);
        }
        LinearLayout firstPage = (LinearLayout) findViewById(R.id.firstpage_item);
        LinearLayout Auction = (LinearLayout) findViewById(R.id.auction_item);
        LinearLayout Message = (LinearLayout) findViewById(R.id.message_item);
        LinearLayout Mine = (LinearLayout) findViewById(R.id.mine_item);
        firstPage.setOnClickListener(this);
        Auction.setOnClickListener(this);
        Message.setOnClickListener(this);
        Mine.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.firstpage_item){
            Intent intent = new Intent(this.getContext(), MainActivity.class);
            this.getContext().startActivity(intent);
        }else if(v.getId() == R.id.auction_item){
            Intent intent = new Intent(this.getContext(), AuctionActivity.class);
            this.getContext().startActivity(intent);
        }else if(v.getId() == R.id.message_item){
            Intent intent = new Intent(this.getContext(), MessageActivity.class);
            this.getContext().startActivity(intent);
        }else if(v.getId() == R.id.mine_item){
            Intent intent = new Intent(this.getContext(), MineActivity.class);
            this.getContext().startActivity(intent);
        }
    }
}
