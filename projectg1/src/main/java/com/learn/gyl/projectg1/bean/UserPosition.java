package com.learn.gyl.projectg1.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by admin on 2016/8/22.
 */
@Table(name = "UserPosition")
public class UserPosition {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "position")
    private String position;
    @Column(name = "flag")
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
}
