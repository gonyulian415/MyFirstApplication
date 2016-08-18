package com.learn.gyl.projectg1.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.learn.gyl.projectg1.bean.Result;
import com.learn.gyl.projectg1.utils.XHttpUtils;
import com.learn.gyl.projectg1.view.IMainView;

import org.xutils.common.Callback;

/**
 * Created by admin on 2016/8/18.
 */
public class TestPresenter {
    private IMainView iMainView;
    private final String URL = "https://api.thinkpage.cn/v3/weather/now.json?key=pqfsoeh1da1fvxjf&location=beijing&language=zh-Hans&unit=c";
    private String response;

    public TestPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }
    public String testMethod(){
        XHttpUtils.requestData(URL, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("xyz",result);
                Gson gson = new Gson();
                Result ex = new Result();
                ex = gson.fromJson(result,Result.class);
                Log.d("xyz",ex.getResults().get(0).getNow().getTemperature());
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
        return "";
    }
}
