package com.example.rebuy;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends BaseActivity {

    private Boolean isLove = false;
    private ImageView Love;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView libel = (TextView)findViewById(R.id.lible);
        libel.setText("商品详情");
        Love = (ImageView) findViewById(R.id.islove);
        Love.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isLove){
                    Love.setImageResource(R.drawable.love);
                    isLove = false;
                }else{
                    Love.setImageResource(R.drawable.love_fill);
                    isLove = true;
                }
            }
        });
    }
}
