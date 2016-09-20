package com.learn.gyl.projectg1.db;

import com.learn.gyl.projectg1.bean.UserPosition;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/22.
 */
public class LocalPositionDB {
    private DbManager dbManager;

    public LocalPositionDB() {
        dbManager = DatabaseOpenHelper.getInstance();
    }

    public List<UserPosition> requestUserPositionData(){
        List<UserPosition> list = null;
        try {
            list = dbManager.selector(UserPosition.class).findAll();
            if (list == null){
                list = new ArrayList<UserPosition>();
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveUserPosition(UserPosition userPosition){
        try {
            dbManager.save(userPosition);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
