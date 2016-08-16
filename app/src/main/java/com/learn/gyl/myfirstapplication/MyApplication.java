package com.learn.gyl.myfirstapplication;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;

/**
 * Created by admin on 2016/7/26.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        ApiStoreSDK.init(this,"2fb9af948e6091bc989724dd3c166434");
        super.onCreate();
    }
}
