package com.example.rebuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationPublishActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_publish);
        TextView libel = (TextView) findViewById(R.id.lible);
        libel.setText("发布信息");
    }
}
