package com.learn.gyl.projectg1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
    @ViewInject(R.id.weather_bg2)
    private ImageView imageView;
    @ViewInject(R.id.testButton1)
    private AppCompatButton testButton1;
    @ViewInject(R.id.testButton2)
    private AppCompatButton testButton2;
    @ViewInject(R.id.testTextView)
    private TextView textView;
    private TestPresenter testPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_test_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        imageView.setAlpha(180);
        testPresenter = new TestPresenter(this);
        testPresenter.testMethod();
        try {
            Log.d("xyz", new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("assets/" + "Provinces.xml"))).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProvinceXmlParse provinceXmlParse = new ProvinceXmlParse();
        List<City> list = provinceXmlParse.parse(this.getClass().getClassLoader().getResourceAsStream("assets/" + "Provinces.xml"));
//        for (City city:list){
//            Log.d("xyz",city.toString());
//        }
    }

    @Override
    public void updateWeather(Result result) {

    }
}
