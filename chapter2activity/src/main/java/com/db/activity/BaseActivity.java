package com.db.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述：     @自定义Activity基类，实现一些基础共有方法
 * @作者：     @Bin
 * @创建时间： @2018/11/6 16:44
 */
class BaseActivity extends AppCompatActivity {

    private final static String TAG = "BaseActivity";
    private List<Activity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"The current activity is " + getClass().getSimpleName());
        addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }

    /**
     * 添加Activity
     * @param activity
     */
    private void addActivity(Activity activity){
        activityList.add(activity);
    }

    /**
     * 移除Activity
     * @param activity
     */
    private void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    /**
     * 结束所有Activity
     */
    private void finishAll(){
        for (Activity activity : activityList){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activityList.clear();
    }
}


