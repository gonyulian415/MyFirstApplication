package com.learn.gyl.myfirstapplication;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by admin on 2016/7/26.
 */
public class OkHttpUtil {
    public static void RequestData(String address,final Callback listener){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(listener);
    }
}
