package com.example.handlepractice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static final String UPPER_NUM = "upper";
    CalThread calThread;
    EditText etNum;

    class CalThread extends Thread{
        public Handler mhandler;

        public void run(){
            Looper.prepare();
            mhandler = new Handler(){
              @Override
                public void handleMessage(Message msg){
                  if(msg.what == 123){
                      int upper = msg.getData().getInt(UPPER_NUM);
                      List<Integer> nums = new ArrayList<>();
                      for (int i = 2 ; i <= upper ; i++)
                      {
                          boolean jus = true;
                          // 用i处于从2开始、到i的平方根的所有数
                          for (int j = 2 ; j <= Math.sqrt(i) ; j++)
                          {
                              // 如果可以整除，表明这个数不是质数
                              if(i != 2 && i % j == 0)
                              {
                                  jus = false;
                                  break;
                              }
                          }
                          if(jus == true)
                          nums.add(i);
                      }
                      Toast.makeText(MainActivity.this, nums.toString(), Toast.LENGTH_SHORT).show();
                  }
              }
            };
            Looper.loop();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum = (EditText) findViewById(R.id.inputNum);
        calThread = new CalThread();
        calThread.start();
    }

    public void cal(View source){
        Message message = new Message();
        message.what = 123;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        message.setData(bundle);
        calThread.mhandler.sendMessage(message);
    }
}
