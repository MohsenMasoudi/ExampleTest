package com.example.mohsen.exampletest.data_base.realm_data_base.dao;

import com.example.mohsen.exampletest.data_base.realm_data_base.model.School;

import io.realm.Realm;

public class SchoolDAO {
    private Realm realm;

    public SchoolDAO() {
        realm=Realm.getDefaultInstance();    }
public void save(final School school){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                School realObj=realm.createObject(School.class,school.getId());
                realObj.setManager(school.getManager());

            }
        });
}

}
