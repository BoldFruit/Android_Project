package com.example.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.send_notice);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.send_notice:
                NotificationManager mNotificationManager = (NotificationManager)
                        getSystemService(this.NOTIFICATION_SERVICE);
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    //只在Android O之上需要渠道
                    NotificationChannel notificationChannel = new NotificationChannel("1",
                            "channel1", NotificationManager.IMPORTANCE_DEFAULT);
                    //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，
                    notificationChannel .setDescription("渠道的描述");
                    // 设置通知出现时的闪灯（如果 android 设备支持的话）
                    notificationChannel .enableLights(true);
                    notificationChannel .setLightColor(Color.RED);
                    // 设置通知出现时的震动（如果 android 设备支持的话）
                    notificationChannel .enableVibration(true);
                    notificationChannel .setVibrationPattern(new long[]{1000, 2000, 1000,3000});
                    //如上设置使手机：静止1秒，震动2秒，静止1秒，震动3秒
                    //通知才能正常弹出
                    mNotificationManager.createNotificationChannel(notificationChannel);
                    // 配置通知渠道的属性
                }
                Notification.Builder builder= new Notification.Builder(this,"1");
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("通知标题")
                        .setContentText("通知内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setStyle()
                        .setAutoCancel(true);
                mNotificationManager.notify(1, builder.build());
    }
}}
