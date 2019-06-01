package com.example.servicebestpractice;

/**
 * Created by dell on 2019/5/29.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
