package com.learn.gyl.projectg1.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by admin on 2016/8/18.
 */
@Table(name = "City")
public class City {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "cityName")
    private String cityName;
    @Column(name = "provinceName")
    private String provinceName;

    public City() {
    }

    public City(String cityName, String provinceName) {
        this.cityName = cityName;
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", id=" + id +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
