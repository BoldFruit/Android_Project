package com.example.rebuy;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by dell on 2019/6/7.
 */

public class ReturnTitleLayout extends LinearLayout {
    public ReturnTitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.return_title, this);
        ImageView back =  findViewById(R.id.left_arraw);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity) getContext()).finish();
            }
        });
    }
}
