package com.db.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        Button startChromeBtn = findViewById(R.id.button_3);
        startChromeBtn.setOnClickListener(this);

        //获取MainActivity被系统回收之前保存的数据
        if (null != savedInstanceState){
            final String tempData = savedInstanceState.getString("data_key");
            Toast.makeText(this,tempData,Toast.LENGTH_SHORT).show();
        }
    }

    //创建Android手机右上角“三个点”的标志
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //给当前活动创建菜单
        getMenuInflater().inflate(R.menu.main,menu);
        //true，表示允许创建的菜单显示出来；false，表示创建的菜单将无法显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //判断哪一个菜单项
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                startIntent();
                break;
            case R.id.button_3:
                startChrome();
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param requestCode   启动活动时传入的请求码，用来判断数据的来源
     * @param resultCode    在返回数据是传入的处理结果，用来判断处理结果是否成功
     * @param data          携带着返回数据的Intent，用来取值并打印
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    if (!TextUtils.isEmpty(returnData)){
                        Toast.makeText(this,returnData,Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
        }
    }

    /**
     * 该方法保证活动在被回收之前一定会被调用，用来解决活动被回收时临时数据得不到保存的问题
     * @param outState  使用Bundle来保存数据
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }

    /**
     * intent作用：1.启动活动；2.启动服务；3.发送广播
     */
    private void startIntent(){
        // 想下一个活动传递数据
        final String data = "Hello FirstActivity";
        //显示启动
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        intent.putExtra("extra_data",data);

        //隐示启动
//        Intent intent1 = new Intent("com.db.activity.ACTION_START");
//        intent1.addCategory("com.db.activity.MY_CATEGORY");


        //普通启动Activity
//        startActivity(intent);

        //该方法会在活动销毁的时候能够返回一个结果给上一个活动
        startActivityForResult(intent,1);
    }

    /**
     * 使用隐示intent方式打开浏览器
     */
    private void startChrome(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //setData(),接收一个Uri对象，主要用于指定当前Intent正在操作的数据，
        intent.setData(Uri.parse("https://www.baidu.com"));
        startActivity(intent);
    }
}
