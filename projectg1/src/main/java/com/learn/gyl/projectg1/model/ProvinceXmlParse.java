package com.learn.gyl.projectg1.model;

import android.util.Log;

import com.learn.gyl.projectg1.bean.City;
import com.learn.gyl.projectg1.bean.Province;
import com.learn.gyl.projectg1.db.CityDB;
import com.learn.gyl.projectg1.db.ProvinceDB;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yl on 2016/8/19.
 */
public class ProvinceXmlParse {
    CityDB cityDB = null;
    ProvinceDB provinceDB = null;
    public List<City> parse(InputStream inputStream){
        List<City> list = null;
        City city = null;
        Province province = null;
        //创建并初始化City对象和装载City对象的List
        try {
            XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
            //获取XmlPullParser对象
            xmlPullParser.setInput(inputStream,"UTF-8");
            //设置输入流，指定编码方式
            int eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:      //判断当前事件是否是文档开始事件
                        list = new ArrayList<City>();         //初始化list
                        cityDB = new CityDB();              //初始化CityDB
                        provinceDB = new ProvinceDB();
                        break;
                    case XmlPullParser.START_TAG:           //判断当前事件是否是标签元素开始事件
                        if ("province".equals(xmlPullParser.getName())){
                            city = new City();
                            province = new Province();
                            if(xmlPullParser.getAttributeValue(0)!=null) {
                                city.setProvinceName(xmlPullParser.getAttributeValue(0));
                                province.setProvinceName(xmlPullParser.getAttributeValue(0));
                                provinceDB.saveProvince(province);
                            }
                        }
                        while ("item".equals(xmlPullParser.getName())){
                            eventType = xmlPullParser.next();
                            if (xmlPullParser.getText()!=null){
                                city.setCityName(xmlPullParser.getText());
                                cityDB.saveCity(city);
                                //provinceDB.saveProvince(province);
                                list.add(city);
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:             //判断当前事件是否是标签元素结束事件
                        if ("province".equals(xmlPullParser.getName())){
                            city = null;
                        }
                        break;
                }
                eventType = xmlPullParser.next();
                //进入下一个事件
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("xmlparse","parse succeed!");
        return list;
    }
}
