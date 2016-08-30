package com.learn.gyl.projectg1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.learn.gyl.projectg1.bean.City;
import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.bean.WeatherIfo;
import com.learn.gyl.projectg1.bean.WeatherIfoBean;
import com.learn.gyl.projectg1.db.WeatherIfoBeanDB;
import com.learn.gyl.projectg1.model.ProvinceXmlParse;
import com.learn.gyl.projectg1.presenter.MainPresenter;
import com.learn.gyl.projectg1.presenter.TestPresenter;
import com.learn.gyl.projectg1.utils.WeatherParseUtil;
import com.learn.gyl.projectg1.view.IMainView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements IMainView {
    Handler handler = new Handler();
    @ViewInject(R.id.weather_drawer)
    private DrawerLayout drawerLayout;
    @ViewInject(R.id.weatherPosition)
    private TextView tv1;               //主界面地理位置
    @ViewInject(R.id.todayweather)
    private ImageView iv1;              //主界面天气四个大字
    @ViewInject(R.id.weather_main_bg1)
    private ImageView iv2;              //主界面天气背景图
    @ViewInject(R.id.drawer_fab)
    private FloatingActionButton fab;
    @ViewInject(R.id.right_drawer_listview)
    private ListView rightListView;
    @ViewInject(R.id.weather_right_drawer)
    private LinearLayout right_drawer;
    private TestPresenter testPresenter;
    private MainPresenter mainPresenter = new MainPresenter(this);
    private WeatherIfoBean weatherIfoBean;
    private ArrayAdapter<String> rightAdapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        Intent intent = getIntent();
        rightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityName = null;
                cityName = list.get(position);
                try {
                    cityName = URLEncoder.encode(cityName,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                mainPresenter.requestWeatherData(cityName);
            }
        });
        rightListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("提示");
                alert.setMessage("确定删除该城市?");
                alert.setCancelable(false);
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = list.get(position);
                        list.remove(position);
                        new WeatherIfoBeanDB().deleteCity(name);
                        rightAdapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //此处留空默认点击关闭提示框
                    }
                });
                alert.show();
                return false;
            }
        });
        if (intent.getStringExtra("cityName") == null){
            Log.d("xyz","intent is null");
            mainPresenter.initWeatherIfo();
        }else {
            String cityName = intent.getStringExtra("cityName");
            mainPresenter.requestWeatherData(cityName);
        }
    }

    @Override
    public void updateWeather(WeatherIfoBean weatherIfoBean) {
        WeatherIfo weatherIfo = WeatherParseUtil.weatherParse(Integer.parseInt(weatherIfoBean.getCode()));
        tv1.setText(URLDecoder.decode(weatherIfoBean.getPosition()));
        iv1.setImageResource(weatherIfo.getMian_text());
        iv2.setImageResource(weatherIfo.getMain_bg());
        drawerLayout.closeDrawers();
    }

    @Override
    public void updateRightListView(List<String> list) {
        this.list = list;
        rightAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.list);
        rightListView.setAdapter(rightAdapter);
    }

    @Event(value = {R.id.drawer_fab})
    private void clickEvent(View view){
        switch (view.getId()){
            case R.id.drawer_fab:
                Intent intent = new Intent(MainActivity.this,CitySelectActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!drawerLayout.isDrawerOpen(right_drawer)) {
            ActivityController.finishAll();
        }
        drawerLayout.closeDrawers();//drawer打开的情况下按back键关闭drawer;drawer关闭的情况下按back退出app
        Log.d("xyz", "back");
    }
}
