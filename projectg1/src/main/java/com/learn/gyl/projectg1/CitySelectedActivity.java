package com.learn.gyl.projectg1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.learn.gyl.projectg1.BaseActivity;
import com.learn.gyl.projectg1.R;
import com.learn.gyl.projectg1.bean.City;
import com.learn.gyl.projectg1.bean.Province;
import com.learn.gyl.projectg1.presenter.CitySelectPresenter;
import com.learn.gyl.projectg1.view.ICitySelectView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by yl on 2016/8/25.
 */
public class CitySelectedActivity extends BaseActivity implements ICitySelectView{
    @ViewInject(R.id.city_select_listview)
    private ListView listView;
    private CitySelectPresenter citySelectPresenter;
    private List<City> cityList;
    private ArrayAdapter<City> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cityselect_layout);
        x.view().inject(this);
        citySelectPresenter = new CitySelectPresenter(this);
        Intent intent = getIntent();
        String provinceName = intent.getStringExtra("province");
        cityList = citySelectPresenter.loadCityData(provinceName);
        citySelectPresenter.updateView();
    }

    @Override
    public void updateListview() {
        arrayAdapter = new ArrayAdapter<City>(this,android.R.layout.simple_list_item_1,cityList);
        listView.setAdapter(arrayAdapter);
    }
}
