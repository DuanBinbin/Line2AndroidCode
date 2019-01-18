package com.db.broadcast;

import android.app.Application;
import android.content.Context;

/**
 * @描述：     @
 * @作者：     @Bin
 * @创建时间： @2019/1/18 14:58
 */
public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static final Context getContext(){
        return mContext;
    }
}
