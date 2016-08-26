package com.learn.gyl.projectg1.view;

import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.bean.WeatherIfoBean;

import java.util.Map;

/**
 * Created by admin on 2016/8/18.
 */
public interface IMainView {
    void updateWeather(WeatherIfoBean weatherIfoBean);
    void updateRightListView();
}
