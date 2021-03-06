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
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
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
import android.widget.Toast;

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
import java.text.SimpleDateFormat;
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
    @ViewInject(R.id.weather_date)
    private TextView dateTextView;
    @ViewInject(R.id.weather_swipe)
    private SwipeRefreshLayout swipeRefreshLayout;
    @ViewInject(R.id.todayweathertext)
    private TextView weatherText;
    @ViewInject(R.id.todaytemperature)
    private TextView temperature;
    @ViewInject(R.id.lastupdatetime)
    private TextView lastUpdateTime;
    private TestPresenter testPresenter;
    private MainPresenter mainPresenter = new MainPresenter(this);
    private WeatherIfoBean weatherIfoBean;
    private ArrayAdapter<String> rightAdapter;
    private List<String> list;
    private long exitTime = 0;
    private String updateTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        drawerLayout.setScrimColor(Color.TRANSPARENT);//取消抽屉阴影
        Intent intent = getIntent();
        rightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityName = null;
                cityName = list.get(position);
                try {
                    cityName = URLEncoder.encode(cityName, "UTF-8");
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
                        String nextName = list.get(position + 1);
                        list.remove(position);
                        try {
                            new WeatherIfoBeanDB().deleteCity(URLEncoder.encode(name, "UTF-8"));
                            mainPresenter.requestWeatherData(URLEncoder.encode(nextName, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
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
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    mainPresenter.requestWeatherData(URLEncoder.encode(tv1.getText().toString(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
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
        weatherText.setText(weatherIfoBean.getWeathertext());
        temperature.setText(weatherIfoBean.getTemperature() + "℃");
//        updateTime = weatherIfoBean.getUpdatetime().split("\\+")[0];
        lastUpdateTime.setText("最后更新于：" + new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss").format(new java.util.Date()));
        try {
            Toast.makeText(getApplicationContext(),URLDecoder.decode(weatherIfoBean.getPosition(),"UTF-8") + weatherIfoBean.getUpdatetime().split("\\+")[0].split("T")[1] + "发布",Toast.LENGTH_SHORT).show();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        drawerLayout.closeDrawers();
    }

    @Override
    public void updateRightListView(List<String> list) {
//        String temp = list.get(list.size()-1);
//        list.remove(list.size()-1);
//        list.add(0, temp);
//        Log.d("xyz",temp);
        this.list = list;
        rightAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.list);
        rightListView.setAdapter(rightAdapter);
    }

    @Override
    public void updateDate(String date) {
        dateTextView.setText(date);
    }

    @Override
    public void closeSwipe() {
        if (swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Event(value = {R.id.drawer_fab,R.id.weatherPosition})
    private void clickEvent(View view){
        switch (view.getId()){
            case R.id.drawer_fab:
                Intent intent = new Intent(MainActivity.this,CitySelectActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherPosition:
                drawerLayout.openDrawer(Gravity.RIGHT);
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
//        if (!drawerLayout.isDrawerOpen(right_drawer)) {
//            ActivityController.finishAll();
//        }
//        drawerLayout.closeDrawers();//drawer打开的情况下按back键关闭drawer;drawer关闭的情况下按back退出app
//        Log.d("xyz", "back");
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && (!drawerLayout.isDrawerOpen(right_drawer))){
            if ((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                ActivityController.finishAll();
            }
            return true;//一定要有
        }
        drawerLayout.closeDrawers();//drawer打开的情况下按back键关闭drawer;drawer关闭的情况下按back退出app
        return true;
        //return super.onKeyDown(keyCode, event);
    }
}
