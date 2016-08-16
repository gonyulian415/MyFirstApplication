package com.learn.gyl.myfirstapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://www.weather.com.cn/data/list3/city.xml";
    String httpUrl = "http://apis.baidu.com/apistore/weatherservice/cityid";
    String httpArg = "cityname=beijing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("xyz", "000");
        Parameters parameters = new Parameters();
        parameters.put("cityid","101010100");
        ApiStoreSDK.execute(httpUrl, ApiStoreSDK.GET, parameters, new ApiCallBack() {
            @Override
            public void onSuccess(int i, String s) {
                Log.d("xyz", s);
                Gson gson = new Gson();
                Weather weather = new Weather();
                weather = gson.fromJson(s, Weather.class);
                Log.d("xyz","天气状况:" + weather.getRetData().getWeather());
            }

            @Override
            public void onError(int i, String s, Exception e) {
                Log.d("xyz", i + "" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("xyz", "complete");
            }
        });
        Log.d("xyz", "222");
    }





}
