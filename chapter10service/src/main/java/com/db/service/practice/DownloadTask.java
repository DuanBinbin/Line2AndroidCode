package com.db.service.practice;

import android.os.AsyncTask;

/**
 * @描述：     @实现下载功能
 * @作者：     @Bin
 * @创建时间： @2018/10/17 16:22
 */
public final class DownloadTask extends AsyncTask<String,Integer,Integer>{

    public static final int TYPE_SUCCESS    = 0;
    public static final int TYPE_FAILED     = 1;
    public static final int TYPE_PAUSED     = 2;
    public static final int TYPE_CANCELED   = 3;

    private DownloadListener mDownloadListener;
    private boolean isCanceled  = false;
    private boolean isPaused    = false;
    private int lastProgress;

    public DownloadTask(DownloadListener downloadListener){
        this.mDownloadListener = downloadListener;
    }


    @Override
    protected Integer doInBackground(String... strings) {
        return null;
    }
}
