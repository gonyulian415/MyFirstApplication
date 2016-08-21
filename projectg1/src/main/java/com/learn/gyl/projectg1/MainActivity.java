package com.learn.gyl.projectg1;

import android.content.Intent;
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
import com.learn.gyl.projectg1.model.ProvinceXmlParse;
import com.learn.gyl.projectg1.presenter.MainPresenter;
import com.learn.gyl.projectg1.presenter.TestPresenter;
import com.learn.gyl.projectg1.view.IMainView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {
    Handler handler = new Handler();
    @ViewInject(R.id.weather_drawer)
    private DrawerLayout drawerLayout;
    private TestPresenter testPresenter;
    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        mainPresenter = new MainPresenter(this);
        mainPresenter.requestWeatherData("guangzhou");
    }

    @Override
    public void updateWeather(Result result) {

    }
}
