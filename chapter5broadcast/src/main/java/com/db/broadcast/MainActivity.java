package com.db.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private IntentFilter intentFilter;

    private NetworkChangeReceiver mNetworkChangeReceiver;
    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册监听网络变化
        //网络发生改变时，系统会发出一天"android.net.conn.CONNECTIVITY_CHANGE"广播
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        mNetworkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(mNetworkChangeReceiver,intentFilter);

        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter1 = new IntentFilter("com.db.broadcast.MY_BROADCAST");
        registerReceiver(myBroadcastReceiver,intentFilter1);

        // 注册本地广播
        //LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcastReceiver,intentFilter1);

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetworkChangeReceiver);
        unregisterReceiver(myBroadcastReceiver);

        // 解除本地广播
        //LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReceiver);
    }

    private void initView(){
        Button sendBroadcastBtn = findViewById(R.id.send_normal_broadcast);
        sendBroadcastBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_normal_broadcast:
                Intent intent = new Intent("com.db.broadcast.MY_BROADCAST");
                // Send Normal Broadcast
                sendBroadcast(intent);
                // Send Ordered Broadcast
                sendOrderedBroadcast(intent,null);
                // Send Local Broadcast
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 网络状态发生改变时，onReceive()方法就会得到执行
     */
    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectivityManager =
                    (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
