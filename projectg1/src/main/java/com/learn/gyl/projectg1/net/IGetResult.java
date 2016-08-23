package com.learn.gyl.projectg1.net;

import com.learn.gyl.projectg1.bean.Result;

import org.xutils.common.Callback;

/**
 * Created by admin on 2016/8/23.
 */
public interface IGetResult {
    Result getResult(Callback.CommonCallback listener,String cityName);
}
