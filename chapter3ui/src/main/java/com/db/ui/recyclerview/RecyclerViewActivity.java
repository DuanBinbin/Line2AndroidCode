package com.db.ui.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.db.funcbasic.BaseActivity;
import com.db.ui.R;
import com.db.ui.listview.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initFruits();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //普通Recycler
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //瀑布流Recycler
        //PS:此处虽然设置了VERTiCAL,
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        //设置横版的RecycleView
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    public static void startRecyclerViewActivity(Context context){
        Intent intent = new Intent(context,RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    private void initFruits(){
        for (int i = 0;i < 2; i++){
            Fruit apple = new Fruit(getRandomLengthName("Apple"),R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit(getRandomLengthName("Banana"),R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"),R.drawable.watermelon_pic);
            fruitList.add(watermelon);

            Fruit pear = new Fruit(getRandomLengthName("Pear"),R.drawable.pear_pic);
            fruitList.add(pear);

            Fruit grape = new Fruit(getRandomLengthName("Grape"),R.drawable.grape_pic);
            fruitList.add(grape);

            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.drawable.pineapple_pic);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.drawable.strawberry_pic);
            fruitList.add(strawberry);

            Fruit cherry = new Fruit(getRandomLengthName("Cherry"),R.drawable.cherry_pic);
            fruitList.add(cherry);

            Fruit mango = new Fruit(getRandomLengthName("Mango"),R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <length; i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
