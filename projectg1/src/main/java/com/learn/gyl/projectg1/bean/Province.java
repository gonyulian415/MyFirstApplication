package com.learn.gyl.projectg1.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by admin on 2016/8/18.
 */
@Table(name = "Province")
public class Province {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "provinceName")
    private String provinceName;

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public Province() {
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
}
