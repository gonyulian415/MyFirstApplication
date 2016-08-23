package com.learn.gyl.projectg1.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.bean.UserPosition;
import com.learn.gyl.projectg1.bean.WeatherIfoBean;
import com.learn.gyl.projectg1.db.LocalPositionDB;
import com.learn.gyl.projectg1.db.WeatherIfoBeanDB;
import com.learn.gyl.projectg1.utils.XHttpUtils;
import com.learn.gyl.projectg1.view.IMainView;

import org.xutils.common.Callback;

import java.util.List;

/**
 * Created by yl on 2016/8/21.
 */
public class MainPresenter{
    private IMainView iMainView;
    private StringBuilder url = new StringBuilder("https://api.thinkpage.cn/v3/weather/now.json?key=pqfsoeh1da1fvxjf&language=zh-Hans&unit=c");
    private LocalPositionDB localPositionDB;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }
    public void requestWeatherData(final String cityName){
        url.append("&location=" + cityName);
        Log.d("xyz",url.toString());
        XHttpUtils.requestData(url.toString(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Result result = gson.fromJson(s, Result.class);
                WeatherIfoBean weatherIfoBean = new WeatherIfoBean();
                weatherIfoBean.setCode(result.getResults().get(0).getNow().getCode());
                weatherIfoBean.setPosition(cityName);
                weatherIfoBean.setTemperature(result.getResults().get(0).getNow().getTemperature());
                Log.d("xyz",result.getResults().get(0).getNow().getCode()+result.getResults().get(0).getNow().getTemperature()+"");
                new WeatherIfoBeanDB().saveWeatherIfoBean(weatherIfoBean);
                iMainView.updateWeather(weatherIfoBean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("xyz",ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("xyz",cex.toString());
            }

            @Override
            public void onFinished() {

            }
        });
    }
    public String requestLocalPosition(){
        String localPosition = null;
        localPosition = "guangzhou";
        //获取当地地名功能未实现
        return localPosition;
    }
    public void initWeatherIfo(){
        localPositionDB = new LocalPositionDB();
        List<UserPosition> list = localPositionDB.requestUserPositionData();    //查询数据库检查是否有用户保存的地理信息
        if (list.isEmpty()){    //如果没有,自动定位用户此时的地理位置
            String localPosition = requestLocalPosition();
            Log.d("xyz","is empty" + localPosition);
            requestWeatherData(localPosition);
        }


    }

}
