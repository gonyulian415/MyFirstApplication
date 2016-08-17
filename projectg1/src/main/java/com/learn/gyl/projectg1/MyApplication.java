package com.learn.gyl.projectg1;

import android.app.Application;

import org.xutils.x;


/**
 * Created by admin on 2016/8/17.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //Xutils3初始化
    }
}
