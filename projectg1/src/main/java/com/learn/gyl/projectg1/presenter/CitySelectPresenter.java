package com.learn.gyl.projectg1.presenter;

import android.widget.ArrayAdapter;

import com.learn.gyl.projectg1.CitySelectActivity;
import com.learn.gyl.projectg1.bean.City;
import com.learn.gyl.projectg1.bean.Province;
import com.learn.gyl.projectg1.db.CityDB;
import com.learn.gyl.projectg1.db.ProvinceDB;
import com.learn.gyl.projectg1.view.ICitySelectView;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class CitySelectPresenter {
    private ICitySelectView iCitySelectView;
    private ProvinceDB provinceDB;
    private List<Province> provinceList;
    private List<City> cityList;
    private CityDB cityDB;
    public CitySelectPresenter(ICitySelectView iCitySelectView) {
        this.iCitySelectView = iCitySelectView;
    }

    public List<Province> loadProvinceData(){
        provinceDB = new ProvinceDB();
        provinceList = provinceDB.loadProvinces();
        return provinceList;
    }

    public List<City> loadCityData(String provinceName){
        cityDB = new CityDB();
        cityList = cityDB.loadCity(provinceName);
        return cityList;
    }

    public void updateView(){
        iCitySelectView.updateListview();
    }
}
