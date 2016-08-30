package com.learn.gyl.projectg1.db;

import android.util.Log;

import com.learn.gyl.projectg1.bean.WeatherIfoBean;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
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

    public boolean queryExsist(String cityName){
        boolean flag = true;
        List<WeatherIfoBean> list = null;
        try {
            list = dbManager.selector(WeatherIfoBean.class).where("position", "=", cityName).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (list.size() == 0){
            flag = false;//如果城市还没存过,flag设为false
            Log.d("xyz","没存过");
        }
        return flag;
    }

    public void deleteCity(String cityName){
        WhereBuilder whereBuilder = WhereBuilder.b("position","=",cityName);
        try {
            dbManager.delete(WeatherIfoBean.class,whereBuilder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
