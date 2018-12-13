package com.example.mohsen.exampletest;

import android.app.Application;

import com.example.mohsen.exampletest.data_base.greendao_data_base.model.DaoMaster;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setGreenDaoDataBase();
        setRealmDataBase();
    }

    private void setRealmDataBase() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("realDataBase.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private void setGreenDaoDataBase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "green_dao.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getGreenDaoSession() {
        return daoSession;
    }
}
