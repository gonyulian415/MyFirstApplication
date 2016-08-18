package com.learn.gyl.projectg1.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admin on 2016/8/18.
 */
public class XHttpUtils {
    public static void requestData(String url,final Callback.CommonCallback<String> listener,String... requestParams){
        RequestParams requestUrl = new RequestParams(url);
        if (requestParams.length > 0){
            //这里的判断不能写成requestParams != null,因为不传值的时候
            //requestParams并不为空
            requestUrl.addQueryStringParameter(requestParams[0], requestParams[1]);
        }
        x.http().get(requestUrl,listener);
    }
}
