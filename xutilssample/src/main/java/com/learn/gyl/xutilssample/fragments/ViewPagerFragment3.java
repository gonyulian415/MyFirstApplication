package com.learn.gyl.xutilssample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.gyl.xutilssample.R;

/**
 * Created by admin on 2016/8/8.
 */
public class ViewPagerFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpager3_layout,container,false);
    }
}
