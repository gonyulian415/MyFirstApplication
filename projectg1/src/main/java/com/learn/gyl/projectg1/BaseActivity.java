package com.learn.gyl.projectg1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2016/8/16.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CurrentActivity",getClass().getSimpleName());
        //获取当前界面对应的Activity的名字
    }

    @Override
    public void onClick(View v) {

    }
}
