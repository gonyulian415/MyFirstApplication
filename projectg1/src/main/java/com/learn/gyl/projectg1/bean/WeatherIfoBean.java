package com.learn.gyl.projectg1.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by yl on 2016/8/23.
 */
@Table(name = "WeatherIfoBean")
public class WeatherIfoBean {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "position")
    private String position;
    @Column(name = "temperature")
    private String temperature;
    @Column(name = "code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
