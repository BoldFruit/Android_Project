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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    private EditText hostname;
    private EditText password;
    private EditText comfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button cancel_register = (Button) findViewById(R.id.cancel_action);
        Button comfirm_register = (Button) findViewById(R.id.comfirm_register);
        hostname = (EditText) findViewById(R.id.hostname1);
        password = (EditText) findViewById(R.id.password1);
        comfirmPassword = (EditText) findViewById(R.id.rePassword);
        cancel_register.setOnClickListener(this);
        comfirm_register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancel_action) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.comfirm_register) {
            String inputHostname = hostname.getText().toString();
            String inputPassword = password.getText().toString();
            String inputComfirmPassword = comfirmPassword.getText().toString();
            List<User> users = DataSupport.select("hostname").where("hostname = ?", inputHostname).find(User.class);
            Pattern pattern = Pattern.compile("[0-9a-zA-Z]+");
            Matcher matcher1 = pattern.matcher(inputHostname);
            Matcher matcher2 = pattern.matcher(inputPassword);
            Matcher matcher3 = pattern.matcher(inputComfirmPassword);
            if(matcher1.matches() && matcher2.matches() && matcher3.matches()){
                if (users.isEmpty()) {
                    if (inputPassword.equals(inputComfirmPassword)) {
                        User user = new User();
                        user.setHostname(inputHostname);
                        user.setPassword(inputPassword);
                        user.setRememberPassword(false);
                        user.save();
                        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "该用户名已被注册", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "请完善你的信息", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
