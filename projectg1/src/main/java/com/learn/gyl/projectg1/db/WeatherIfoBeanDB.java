package com.learn.gyl.projectg1.db;

import com.learn.gyl.projectg1.bean.WeatherIfoBean;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by yl on 2016/8/23.
 */
public class WeatherIfoBeanDB {
    private DbManager dbManager;

    public WeatherIfoBeanDB() {
        dbManager = DatabaseOpenHelper.getInstance();
    }
    public void saveWeatherIfoBean(WeatherIfoBean weatherIfoBean){
        try {
            dbManager.save(weatherIfoBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<WeatherIfoBean> loadWeatherIfoBean(){
        List<WeatherIfoBean> list = null;
        try {
            list = dbManager.selector(WeatherIfoBean.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }
}
