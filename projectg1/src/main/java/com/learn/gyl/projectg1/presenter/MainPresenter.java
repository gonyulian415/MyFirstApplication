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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yl on 2016/8/21.
 */
public class MainPresenter{
    private IMainView iMainView;
    private String mMonth;
    private String mDay;
    private String mWeek;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }
    public void requestWeatherData(final String cityName){
        StringBuilder url = new StringBuilder("https://api.thinkpage.cn/v3/weather/now.json?key=pqfsoeh1da1fvxjf&language=zh-Hans&unit=c");
        url.append("&location=" + cityName);
        Log.d("xyz",url.toString());
        XHttpUtils.requestData(url.toString(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                List<String> list = new ArrayList<String>();
                List<WeatherIfoBean> list1 = null;
                Gson gson = new Gson();
                Result result = gson.fromJson(s, Result.class);
                WeatherIfoBean weatherIfoBean = new WeatherIfoBean();
                weatherIfoBean.setCode(result.getResults().get(0).getNow().getCode());
                weatherIfoBean.setPosition(cityName);
                weatherIfoBean.setTemperature(result.getResults().get(0).getNow().getTemperature());
                weatherIfoBean.setWeathertext(result.getResults().get(0).getNow().getText());
                weatherIfoBean.setUpdatetime(result.getResults().get(0).getLast_update());
                Log.d("xyz", "code:" + result.getResults().get(0).getNow().getCode() + "temp:" + result.getResults().get(0).getNow().getTemperature() + "");
                if(!new WeatherIfoBeanDB().queryExsist(cityName)) {
                    new WeatherIfoBeanDB().saveWeatherIfoBean(weatherIfoBean);
                    Log.d("xyz",cityName + "weatherIfoBean has saved!");
                }
                list1 = new WeatherIfoBeanDB().loadWeatherIfoBean();
                if (list1 == null){
                    list1 = new ArrayList<WeatherIfoBean>();
                }
                for (WeatherIfoBean w : list1){
                    try {
                        list.add(URLDecoder.decode(w.getPosition(),"UTF-8"));
                        Log.d("xyz",URLDecoder.decode(w.getPosition(),"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                iMainView.updateWeather(weatherIfoBean);
                iMainView.updateRightListView(list);
                iMainView.closeSwipe();
                iMainView.updateDate(aquireData());
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
        localPosition = "广州";
        //获取当地地名功能未实现
        localPosition = URLEncoder.encode(localPosition);
        return localPosition;
    }
    public void initWeatherIfo(){
        WeatherIfoBeanDB weatherIfoBeanDB = new WeatherIfoBeanDB();
        List<WeatherIfoBean> list = weatherIfoBeanDB.loadWeatherIfoBean();    //查询数据库检查是否有用户保存的地理信息
        if ((list == null) || list.isEmpty()){    //如果没有,自动定位用户此时的地理位置
            String localPosition = requestLocalPosition();
            Log.d("xyz", "is empty" + localPosition);
            requestWeatherData(localPosition);//查天气
        }else {
            requestWeatherData(list.get(0).getPosition());
        }
    }

    public String aquireData(){
        String date = null;
        Calendar calendar = Calendar.getInstance();
        mMonth = String.valueOf(calendar.get(Calendar.MONTH)+1);
        mDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        mWeek = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
        switch (mWeek){
            case "1":mWeek = "日";break;
            case "2":mWeek = "一";break;
            case "3":mWeek = "二";break;
            case "4":mWeek = "三";break;
            case "5":mWeek = "四";break;
            case "6":mWeek = "五";break;
            case "7":mWeek = "六";break;
        }
        date = mMonth + "." + mDay + "/" + "周" + mWeek;
        return date;
    }

}
