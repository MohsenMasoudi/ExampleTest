package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Teacher extends RealmObject {
    @PrimaryKey
    private Long id;
    private String firstName;
    private String familyName;
    private Long schoolId;

}
