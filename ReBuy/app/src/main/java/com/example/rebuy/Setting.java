package com.example.rebuy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button button = (Button) findViewById(R.id.exit);
        SharedPreferences sharedPreferences = getSharedPreferences("isLogin", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Setting.this, LoginActivity.class);
                startActivity(intent);
                TextView libel = (TextView) findViewById(R.id.lible);
                libel.setText("设置");
                ActivityCollector.finishAll();
                editor.putBoolean("Login", false);
                editor.apply();
            }
        });
    }
}
