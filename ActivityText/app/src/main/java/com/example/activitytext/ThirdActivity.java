package com.example.activitytext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.activitytext.R.styleable.View;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity", "Task id is"+getTaskId());
        setContentView(R.layout.third_layout);
        Button button = (Button) findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(android.view.View v){
                ActivityColletor.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
