package com.learn.gyl.projectg1.db;

import android.util.Log;

import com.learn.gyl.projectg1.bean.City;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class CityDB {
    private DbManager dbManager;
    private List<City> cityList;

    public CityDB(){
        dbManager = DatabaseOpenHelper.getInstance();
    }

    public void saveCity(City city){
        try {
            dbManager.save(city);
            Log.d("citydb",city.toString());
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<City> loadCity(String provinceName){
        try {
            cityList = dbManager.selector(City.class).where("provinceName","=",provinceName).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (cityList == null){
            cityList = new ArrayList<City>();
        }
        return cityList;
    }

}
