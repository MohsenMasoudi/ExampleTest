package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject {
    @PrimaryKey
    private Long id;
    private Long schoolId;
    private String firstName;
    private String familyName;
    private long studentNumber;
    private RealmList<Lesson> lessons;
    private RealmList<Grade> grades;
    @Ignore
    private String ignorExample;

}
