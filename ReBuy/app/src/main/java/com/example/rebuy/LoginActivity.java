package com.example.rebuy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText hostname ;
    private EditText password ;
    private SharedPreferences isRemmember;
    private SharedPreferences isLogin;
    private SharedPreferences.Editor edit_rem;
    private SharedPreferences.Editor edit_login;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        hostname = (EditText) findViewById(R.id.hostname);
        password = (EditText) findViewById(R.id.password);
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        isLogin = getSharedPreferences("isLogin", MODE_PRIVATE);
        isRemmember = getSharedPreferences("isRemmember", MODE_PRIVATE);
        rememberPass = (CheckBox) findViewById(R.id.remember_password);
        boolean remmerberPass = isRemmember.getBoolean("Remmember", false);
        boolean islogin = isLogin.getBoolean("Login", false);
        if(islogin){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(remmerberPass){
            String account = isRemmember.getString("account", "");
            String password1 = isRemmember.getString("password", "");
            hostname.setText(account);
            password.setText(password1);
            rememberPass.setChecked(true);
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
                edit_rem = isRemmember.edit();
                if(rememberPass.isChecked()){
                    edit_rem.putBoolean("Remmember", true);
                    edit_rem.putString("account", inputPassword);
                    edit_rem.putString("password", inputPassword);
                }else{
                    edit_rem.clear();
                }
                edit_rem.apply();
                edit_login = isLogin.edit();
                edit_login.putBoolean("Login", true);
                edit_login.apply();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
