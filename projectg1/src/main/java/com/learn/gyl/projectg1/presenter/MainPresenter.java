package com.learn.gyl.projectg1.presenter;

import android.util.Log;

import com.learn.gyl.projectg1.view.IMainView;

/**
 * Created by yl on 2016/8/21.
 */
public class MainPresenter {
    private IMainView iMainView;
    private StringBuilder url = new StringBuilder("https://api.thinkpage.cn/v3/weather/now.json?key=pqfsoeh1da1fvxjf&language=zh-Hans&unit=c");

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }
    public void requestWeatherData(String cityName){
        url.append("&location=" + cityName);
        Log.d("xyz",url.toString());
    }
}
