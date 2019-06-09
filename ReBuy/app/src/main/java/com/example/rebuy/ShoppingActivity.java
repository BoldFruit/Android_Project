package com.example.rebuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {

    private ShoppingAdapter adapter;
    private View v1;
    private View v2;
    private View v3;
    private LinearLayout libel1;
    private LinearLayout libel2;
    private LinearLayout libel3;
    private TextView libel;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        adapter = new ShoppingAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        v1 = (View) findViewById(R.id.view1);
        v2 = (View) findViewById(R.id.view2);
        v3 = (View) findViewById(R.id.view3);
        libel = (TextView) findViewById(R.id.lible);
        libel.setText("随便逛逛");
        libel1 = (LinearLayout) findViewById(R.id.lible1);
        libel2 = (LinearLayout) findViewById(R.id.lible2);
        libel3 = (LinearLayout) findViewById(R.id.lible3);
        libel1.setOnClickListener(this);
        libel2.setOnClickListener(this);
        libel3.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.shopping_recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.lible1:
                if(v1.getVisibility() == View.VISIBLE){
                    v1.setVisibility(View.INVISIBLE);
                }else{
                    v1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.lible2:
                if(v2.getVisibility() == View.VISIBLE){
                    v2.setVisibility(View.INVISIBLE);
                }else{
                    v2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.lible3:
                if(v3.getVisibility() == View.VISIBLE){
                    v3.setVisibility(View.INVISIBLE);
                }else{
                    v3.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
    public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View view){
                super(view);
            }
        }
        public ShoppingAdapter(){}
        @Override
        public ShoppingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(view.getContext(), DetailActivity.class );
                    startActivity(intent);
                }
            });
            ShoppingAdapter.ViewHolder holder = new ShoppingAdapter.ViewHolder (view);
            return holder;
        }
        @Override
        public void onBindViewHolder(ShoppingAdapter.ViewHolder holder, int position){

        }
        @Override
        public int getItemCount(){
            return 20;
        }
    }
}
