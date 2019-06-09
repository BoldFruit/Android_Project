package com.example.rebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by dell on 2019/6/1.
 */

public class MineFragment extends Fragment implements View.OnClickListener{

    public MineFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine, container, false);
        LinearLayout myStore = (LinearLayout) view.findViewById(R.id.my_store);
        LinearLayout myOrder = (LinearLayout) view.findViewById(R.id.my_menu) ;
        LinearLayout myCollection = (LinearLayout) view.findViewById(R.id.my_collection) ;
        LinearLayout setting = (LinearLayout) view.findViewById(R.id.setting);
        LinearLayout personalDate = (LinearLayout) view.findViewById(R.id.personal_data);
        setting.setOnClickListener(this);
        personalDate.setOnClickListener(this);
        myOrder.setOnClickListener(this);
        myStore.setOnClickListener(this);
        myCollection.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.my_store:
                Intent intent1 = new Intent(getContext(), MyStoreActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_menu:
                Intent intent2 = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent2);
                break;
            case R.id.my_collection:
                Intent intent3 = new Intent(getContext(), MyCollection.class);
                startActivity(intent3);
                break;
            case R.id.setting:
                Intent intent4 = new Intent(getContext(), Setting.class);
                startActivity(intent4);
                break;
            case R.id.personal_data:
                Intent intent5 = new Intent(getContext(), PersonalData.class);
                startActivity(intent5);
            default:
                break;
        }
    }


}
