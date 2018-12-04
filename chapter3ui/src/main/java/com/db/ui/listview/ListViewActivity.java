package com.db.ui.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.db.funcbasic.BaseActivity;
import com.db.ui.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity {

    private String[] data =
            {"Apple","Banana","Orange","Watermelon","Pear","Grape","" +
                    "Pineapple","Strawberry","Cherry","Mango", "Apple","Banana","Orange","" +
                    "Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //1.常规ListView:为什么需要适配器：数组中的数据无法直接传递给ListView，需要借助适配器完成
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                ListViewActivity.this,          //当前context
//                android.R.layout.simple_list_item_1,    //Android内置的布局文件
//                data);

        //2.自定义ListView
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this,R.layout.custom_fruit_item,fruitList);

        ListView listView = findViewById(R.id.list_view);

        //将构建好的适配器对象传递的ListView中
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(getApplicationContext(),fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void startListViewActivity(Context context){
        Intent intent = new Intent(context,ListViewActivity.class);
        context.startActivity(intent);
    }

    private void initFruits(){
        for (int i = 0;i < 2; i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);

            Fruit pear = new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);

            Fruit grape = new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);

            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);

            Fruit cherry = new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);

            Fruit mango = new Fruit("Mango",R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}
