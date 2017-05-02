package com.example.wjq.app;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.ThemedSpinnerAdapter;

import com.example.wjq.app.adapter.FruitAdapterRecyView;
import com.example.wjq.app.entityclass.BaseActivity;
import com.example.wjq.app.entityclass.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TitleMainActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_main);
        //隐藏系统自带标题
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //使用RecyclerView控件
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平方向
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapterRecyView adapterRecyView = new FruitAdapterRecyView(fruitList);
        recyclerView.setAdapter(adapterRecyView);

    }

    private void initFruits() {

        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(("Apple1"), R.drawable.apple_pic,"");
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic,"111");
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic,"111");
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic,"111");
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic,"111");
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic,"111");
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic,"111");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic,"111");
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic,"111");
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic,"111");
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
       Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();

      //  return name;
    }
}
