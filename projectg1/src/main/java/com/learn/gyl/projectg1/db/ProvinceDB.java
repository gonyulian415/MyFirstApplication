package com.learn.gyl.projectg1.db;

import android.util.Log;

import com.learn.gyl.projectg1.bean.Province;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class ProvinceDB {
    private DbManager dbManager;
    public ProvinceDB(){
        dbManager = DatabaseOpenHelper.getInstance();
    }
    public void saveProvince(Province province){
        try {
            dbManager.save(province);
            Log.d("province",province.toString());
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public List<Province> loadProvinces(){
        List<Province> list = null;
        try {
            list = dbManager.selector(Province.class).findAll();
            if (list == null){
                list = new ArrayList<Province>();
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }
}
