package com.learn.gyl.projectg1;

import android.os.Bundle;

import com.learn.gyl.projectg1.view.ICitySelectView;

/**
 * Created by admin on 2016/8/25.
 */
public class CitySelectActivity extends BaseActivity implements ICitySelectView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cityselect_layout);

    }

    @Override
    public void updateListview() {

    }
}
