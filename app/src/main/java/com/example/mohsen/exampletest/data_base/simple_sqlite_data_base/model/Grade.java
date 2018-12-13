package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model;

import org.greenrobot.greendao.annotation.Entity;

import java.util.ArrayList;
import java.util.UUID;

public class Grade {
    private int id;
    private int lessonId;
    private UUID studentId;
    private int midTermMark;
    private int finalMark;
    private ArrayList<Integer> classMarks;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public int getMidTermMark() {
        return midTermMark;
    }

    public void setMidTermMark(int midTermMark) {
        this.midTermMark = midTermMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    public ArrayList<Integer> getClassMarks() {
        return classMarks;
    }

    public void setClassMarks(ArrayList<Integer> classMarks) {
        this.classMarks = classMarks;
    }



    public Grade(int lessonId, UUID studentId) {
        this.lessonId = lessonId;
        this.studentId = studentId;
    }
}
