package com.learn.gyl.projectg1.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admin on 2016/8/18.
 */
public class XHttpUtils {
    public static void requestData(String url,final Callback.CommonCallback<String> listener){
        RequestParams requestUrl = new RequestParams(url);
        x.http().get(requestUrl,listener);
    }
}
