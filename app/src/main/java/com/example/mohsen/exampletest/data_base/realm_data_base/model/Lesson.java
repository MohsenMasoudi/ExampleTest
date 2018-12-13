package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Lesson extends RealmObject {
    @PrimaryKey

    private Long id;
    private Long studentId;
    private String name;
    private RealmList<Student> students;


}
