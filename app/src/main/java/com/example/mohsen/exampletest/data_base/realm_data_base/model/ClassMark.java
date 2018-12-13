package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClassMark extends RealmObject {
    @PrimaryKey
    private Long id;
    private Long gradeId;
    private int mark;


}
