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

}
