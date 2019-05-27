package com.example.rebuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText hostname ;
    private EditText password ;
    public static Boolean isLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isLogin == false){
            setContentView(R.layout.activity_login);
            hostname = (EditText) findViewById(R.id.hostname);
            password = (EditText) findViewById(R.id.password);
            Button register = (Button) findViewById(R.id.register);
            register.setOnClickListener(this);
            Button login = (Button) findViewById(R.id.login);
            login.setOnClickListener(this);
        }else{
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.register){
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.login){
            String inputPassword = password.getText().toString();
            String inputHostname = hostname.getText().toString();
            List<User> user = DataSupport.select("hostname","password").where("hostname = ? and password = ?",inputHostname,inputPassword).find(User.class);
            if(user.isEmpty()){
                Toast.makeText(this,"密码或用户名错误",Toast.LENGTH_SHORT).show();
            }else{
                isLogin = true;
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
