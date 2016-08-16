package com.learn.gyl.myfirstapplication;

/**
 * Created by admin on 2016/7/24.
 */
public interface HttpCallbackListener {
    public void onFinish(String s);
    public void onError(Exception e);
}
