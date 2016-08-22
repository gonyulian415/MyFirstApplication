package com.learn.gyl.projectg1.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.bean.UserPosition;
import com.learn.gyl.projectg1.db.LocalPositionDB;
import com.learn.gyl.projectg1.utils.XHttpUtils;
import com.learn.gyl.projectg1.view.IMainView;

import org.xutils.common.Callback;

import java.util.List;
import java.util.Map;

/**
 * Created by yl on 2016/8/21.
 */
public class MainPresenter {
    private IMainView iMainView;
    private StringBuilder url = new StringBuilder("https://api.thinkpage.cn/v3/weather/now.json?key=pqfsoeh1da1fvxjf&language=zh-Hans&unit=c");
    private LocalPositionDB localPositionDB;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }
    public Result requestWeatherData(String cityName){
        Result result = null;
        final Gson gson = new Gson();
        url.append("&location=" + cityName);
        Log.d("xyz", url.toString());
        XHttpUtils.requestData(url.toString(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                result = gson.toJson(Result.class);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        return result;
    }
    public String requestLocalPosition(){
        String localPosition = null;
        localPosition = "广州";
        //获取当地地名功能未实现
        return localPosition;
    }
    public Map<String,Result> initWeatherIfo(){
        Map<String,Result> resultMap = null;
        Result result = null;
        localPositionDB = new LocalPositionDB();
        List<UserPosition> list = localPositionDB.requestUserPositionData();    //查询数据库检查是否有用户保存的地理信息
        if (list.isEmpty()){    //如果没有,自动定位用户此时的地理位置
            String localPosition = requestLocalPosition();
            result = requestWeatherData(localPosition);
            resultMap.put(localPosition,result);    //将自动定位地理信息和天气结果装进map里
        }else {     //如果有,读取用户保存地理信息列表,通过for循环将地理信息和天气结果装进map里返回
            for (UserPosition position : list){
                result = requestWeatherData(position.getPosition());
                resultMap.put(position.getPosition(),result);
                result = null;
            }
        }
        return resultMap;
    }
}
