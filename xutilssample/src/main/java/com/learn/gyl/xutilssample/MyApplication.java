package com.learn.gyl.xutilssample;

import android.app.Application;

import org.xutils.x;

/**
 * Created by admin on 2016/7/30.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
