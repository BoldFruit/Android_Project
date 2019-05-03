package com.example.activitytext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by dell on 2019/4/12.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityColletor.addActivity(this);
    }
    protected void onDestory(){
        super.onDestroy();
        ActivityColletor.removeActivity(this);
    }
}
