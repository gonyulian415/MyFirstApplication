package com.learn.gyl.projectg1.db;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by admin on 2016/8/19.
 */
public class DatabaseOpenHelper {
    private DbManager.DaoConfig daoConfig;
    private static DbManager dbManager;
    private final String DB_NAME = "weatherdb";
    private final int VERSION = 1;
    private DatabaseOpenHelper(){
        daoConfig = new DbManager.DaoConfig()
                .setDbName(DB_NAME)
                .setDbVersion(VERSION)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //database update operation
                    }
                });
        dbManager = x.getDb(daoConfig);
    }
    public static DbManager getInstance(){
        if (dbManager == null){
            DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper();
        }
        return dbManager;
    }
}
