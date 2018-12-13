package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model;

import java.util.ArrayList;

public class Teacher {
    private int id;
    private String firstName;
    private String familyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public ArrayList<Integer> getStudentId() {
        return studentId;
    }

    public void setStudentId(ArrayList<Integer> studentId) {
        this.studentId = studentId;
    }

    private int lessonId;
    private ArrayList<Integer> studentId;
}
