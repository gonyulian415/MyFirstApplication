package com.learn.gyl.xutilssample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2016/8/4.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        Log.d("xyz","name:" + typedArray.getString(R.styleable.MyView_gylName) + "age:" + typedArray.getString(R.styleable.MyView_gylAge));
        typedArray.recycle();
    }
}
