package com.db.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.db.service.demo.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private MyService.DownloadBinder mDownloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        /**
         * 活动与服务绑定成功时调用
         * @param componentName
         * @param iBinder
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG,"onServiceConnected() ComponentName = " + componentName.toString());
            mDownloadBinder = (MyService.DownloadBinder) iBinder;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        /**
         * 活动与服务断开时调用
         * @param componentName
         */
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG,"onServiceDisconnected() ComponentName = " + componentName.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        Button startServiceBtn = findViewById(R.id.start_service);
        Button endServiceBtn = findViewById(R.id.end_service);
        Button bindServiceBtn = findViewById(R.id.bind_service);
        Button unbindServiceBtn = findViewById(R.id.unbind_service);

        //按钮绑定点击事件的监听器
        startServiceBtn.setOnClickListener(this);
        endServiceBtn.setOnClickListener(this);
        bindServiceBtn.setOnClickListener(this);
        unbindServiceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                // 启动服务
                Intent startServiceIntent = new Intent(this,MyService.class);
                startService(startServiceIntent);
                break;
            case R.id.end_service:
                // 结束服务
                Intent endServiceIntent = new Intent(this,MyService.class);
                stopService(endServiceIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                // 绑定服务
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                // 解绑服务
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
