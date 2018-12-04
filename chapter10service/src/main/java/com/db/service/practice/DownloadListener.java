package com.db.service.practice;

/**
 * @描述：     @对下载过程中的各种状态进行监听和回调
 * @作者：     @Bin
 * @创建时间： @2018/10/17 16:18
 */
public interface DownloadListener {

    // 下载进度
    void onProgress(int progress);

    // 下载成功
    void onSuccess();

    // 下载失败
    void onFailed();

    // 下载暂停
    void onPaused();

    // 下载取消
    void onCanceled();

}
