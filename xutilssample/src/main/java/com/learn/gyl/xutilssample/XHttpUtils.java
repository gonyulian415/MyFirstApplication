package com.learn.gyl.xutilssample;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by admin on 2016/7/31.
 */
public class XHttpUtils {
    public static void requestData(String url,final Callback.CommonCallback<String> listener,String... requestParams){
        RequestParams requestUrl = new RequestParams(url);
        if (requestParams.length > 0){
            requestUrl.addQueryStringParameter(requestParams[0], requestParams[1]);
        }
        x.http().get(requestUrl,listener);
    }
}
