package com.learn.gyl.projectg1.utils;

import com.learn.gyl.projectg1.R;
import com.learn.gyl.projectg1.bean.WeatherIfo;

/**
 * Created by admin on 2016/8/23.
 */
public class WeatherParseUtil {
    public static WeatherIfo weatherParse(int code){
        WeatherIfo weatherIfo = null;
        switch (code){
            case 1:
            case 2:
            case 3:
            case 4:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.sunny);weatherIfo.setMian_text(R.drawable.qlsy_normal);break;
            case 5:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 6:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 7:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 8:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 9:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 10:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 11:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 12:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 13:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 14:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 15:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 16:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 17:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 18:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 19:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 20:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 21:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 22:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 23:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 24:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 25:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 26:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 27:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 28:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 29:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 30:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 31:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 32:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 33:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 34:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 35:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 36:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 37:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 38:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 99:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
        }
        return weatherIfo;
    }
}
