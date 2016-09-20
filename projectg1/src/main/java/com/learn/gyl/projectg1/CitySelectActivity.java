package com.learn.gyl.projectg1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.learn.gyl.projectg1.bean.Province;
import com.learn.gyl.projectg1.presenter.CitySelectPresenter;
import com.learn.gyl.projectg1.view.ICitySelectView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 * 省份选择Activity
 */
public class CitySelectActivity extends BaseActivity implements ICitySelectView{
    @ViewInject(R.id.city_select_listview)
    private ListView listView;
    private CitySelectPresenter citySelectPresenter;
    private ArrayAdapter<Province> arrayAdapter;
    private List<Province> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cityselect_layout);
        x.view().inject(this);
        citySelectPresenter = new CitySelectPresenter(this);
        list = citySelectPresenter.loadProvinceData();
        citySelectPresenter.updateView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Province province = (Province) list.get(position);
                Intent intent = new Intent(CitySelectActivity.this,CitySelectedActivity.class);
                intent.putExtra("province",province.toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void updateListview() {
        arrayAdapter = new ArrayAdapter<Province>(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

//    @Event(value = {R.id.city_select_listview})
//    private void clickEvent(AdapterView<?> parent, View view, int position,long id){
//        Province province = list.get(position);
//        Snackbar.make(view,province.toString(),Snackbar.LENGTH_SHORT).show();
//    }
}
