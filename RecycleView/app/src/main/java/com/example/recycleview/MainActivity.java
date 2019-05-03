package com.example.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        for(int i=0; i<2;i++){
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.mipmap.ic_launcher);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.mipmap.ic_launcher);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.mipmap.ic_launcher);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.mipmap.ic_launcher);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"),R.mipmap.ic_launcher);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.mipmap.ic_launcher);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.mipmap.ic_launcher);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.mipmap.ic_launcher);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.mipmap.ic_launcher);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.mipmap.ic_launcher);
            fruitList.add(mango);
        }
}
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i= 0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
     }
}
