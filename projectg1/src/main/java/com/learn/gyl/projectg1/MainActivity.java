package com.learn.gyl.projectg1;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.gyl.projectg1.bean.City;
import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.bean.WeatherIfo;
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
    private TestPresenter testPresenter;
    private MainPresenter mainPresenter = new MainPresenter(this);
    private Map<String,Result> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        map = new HashMap<String,Result>();
        map = mainPresenter.initWeatherIfo();     //初始化,返回resultMap<城市名,天气查询结果>
        updateWeather(map);
    }

    @Override
    public void updateWeather(Map<String,Result> result) {
        if (result.size() == 1){    //只有一对时直接更新主界面天气
            Log.d("xyz","主天气");
            for (String s : result.keySet()){
                WeatherIfo weatherIfo = WeatherParseUtil.weatherParse(Integer.parseInt(result.get(s).getResults().get(0).getNow().getCode()));
                iv1.setImageResource(weatherIfo.getMian_text());
                iv2.setImageResource(weatherIfo.getMain_bg());
                tv1.setText(s);
            }
        }else{

        }
    }
}
