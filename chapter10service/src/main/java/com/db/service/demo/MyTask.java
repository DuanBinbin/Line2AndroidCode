package com.db.service.demo;

import android.os.AsyncTask;

/**
 * @描述：     @多线程工具AsyncTask类,从子线程切换到主线程
 * @作者：     @Bin
 * @创建时间： @2018/10/18 11:32
 *
 * @Void        执行任务时传入的参数
 * @Integer     执行任务中显示的进度
 * @Boolean     任务完成后返回的结果
 */
class MyTask extends AsyncTask<Void,Integer,Boolean>{

    /**
     * 任务执行前调用，用处初始化界面
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 1.该方法中的代码都会在子线程中执行，用来处理耗时的操作
     * 2.执行结果通过return返回，为第三个参数
     * 3.注意：不能进行UI操作
     * @param voids
     * @return
     */
    @Override
    protected Boolean doInBackground(Void... voids) {
        //返回当前任务的执行进度，来更新UI元素，***本质上是该方法实现了从子线程切换的UI线程***
        publishProgress(1);
        return null;
    }

    /**
     * 调用publishProgress(Progress...)会执行该方法，用来更新UI
     * @param values    为Progress
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    /**
     * 任务执行完毕并通过return语句进行返回时，调用该方法，返回的结果作为参数传递到此方法中，
     * 常用来刷新任务完成后的UI
     * @param aBoolean
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
