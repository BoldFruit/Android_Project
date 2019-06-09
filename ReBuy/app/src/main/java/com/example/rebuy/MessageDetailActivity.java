package com.example.rebuy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageDetailActivity extends AppCompatActivity {

    public static void actionStart(Context context,int ImageId, String name, String time){
        Intent intent = new Intent(context, MessageDetailActivity.class);
        intent.putExtra("image", ImageId);
        intent.putExtra("name", name);
        intent.putExtra("time", time);
        context.startActivity(intent);
    }
    private ImageView imageView;
    private TextView time;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_datail);
        imageView = (ImageView) findViewById(R.id.cartoon1);
        time = (TextView) findViewById(R.id.time);
        name = (TextView) findViewById(R.id.name);
        Intent intent = getIntent();
        int ImageId = intent.getIntExtra("image",0);
        String intentName = intent.getStringExtra("name");
        String intentTime = intent.getStringExtra("time");
        imageView.setImageResource(ImageId);
        time.setText(intentTime);
        name.setText(intentName);
    }
}
