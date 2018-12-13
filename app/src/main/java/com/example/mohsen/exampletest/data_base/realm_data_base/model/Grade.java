package com.example.mohsen.exampletest.data_base.realm_data_base.model;


import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Grade extends RealmObject {
    @PrimaryKey

    private Long id;
    private Long lessonId;
    private Long studentId;
    private int midTermMark;
    private int finalMark;
    private Lesson lesson;
    private RealmList<ClassMark> classMarks;

}
