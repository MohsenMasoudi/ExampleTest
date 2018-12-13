package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class JoinStudentWithLesson extends RealmObject {
    @PrimaryKey

    private Long id;
    private Long studentId;
    private Long lessonId;

    }
