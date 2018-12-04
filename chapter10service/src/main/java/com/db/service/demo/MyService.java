package com.db.service.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @描述：     @四大组件，service学习
 * @作者：     @Bin
 * @创建时间： @2018/10/18 11:52
*/
public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    private DownloadBinder mBinder = new DownloadBinder();

    public class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d(TAG,"startDownload() execute");
        }

        public int getProgress(){
            Log.d(TAG,"getProgress() execute");
            return 0;
        }
    }

    /**
     * onBind方法是Service中唯一的一个抽象方法，必须在子类中实现
     * 作用：用于活动和服务进行通信
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    /**
     * 每次服务“创建”的时候调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    /**
     * 每次服务“启动”的时候调用，通常将服务一旦启动就立刻去执行的逻辑写在此处
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 每次服务“销毁”的时候调用
     */
    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }
}
