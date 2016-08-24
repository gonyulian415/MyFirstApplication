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
            case 0:
            case 1:
            case 2:
            case 3:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.sunny);weatherIfo.setMian_text(R.drawable.qlsy_normal);break;
            case 4:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.yymb_normal);break;
            case 5:
            case 6:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.sunny);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 7:
            case 8:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.qjdy_normal);break;
            case 9:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.yymb_normal);break;
            case 10:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.rainy);weatherIfo.setMian_text(R.drawable.oyzy_normal);break;
            case 11:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.rainy);weatherIfo.setMian_text(R.drawable.dsly_normal);break;
            case 12:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.rainy);weatherIfo.setMian_text(R.drawable.zybb_normal);break;
            case 13:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.rainy);weatherIfo.setMian_text(R.drawable.xymm_normal);break;
            case 14:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.lightrain3);weatherIfo.setMian_text(R.drawable.zyjl_normal);break;
            case 15:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.lightrain3);weatherIfo.setMian_text(R.drawable.dyqp_normal);break;
            case 16:
            case 17:
            case 18:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.lightrain3);weatherIfo.setMian_text(R.drawable.bylx_normal);break;
            case 19:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.rainy);weatherIfo.setMian_text(R.drawable.dyjl_normal);break;
            case 20:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.xyjx_normal);break;
            case 21:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.oyjx_normal);break;
            case 22:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.lxxx_normal);break;
            case 23:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.xhff_normal);break;
            case 24:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.mtbx_normal);break;
            case 25:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.bxlx_normal);break;
            case 26:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.fcfy_normal);break;
            case 27:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.fcfy_normal);break;
            case 28:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.fcfy_normal);break;
            case 29:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.fcfy_normal);break;
            case 30:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.wqlz_normal);break;
            case 31:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.dusty);weatherIfo.setMian_text(R.drawable.wqlz_normal);break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.cloudy);weatherIfo.setMian_text(R.drawable.dflx_normal);break;
            case 37:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.snow);weatherIfo.setMian_text(R.drawable.wdzj_normal);break;
            case 38:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.sunny);weatherIfo.setMian_text(R.drawable.jrgw_normal);break;
            case 99:weatherIfo = new WeatherIfo();weatherIfo.setMain_bg(R.drawable.start);weatherIfo.setMian_text(R.drawable.jqwy_normal);break;
        }
        return weatherIfo;
    }
}
