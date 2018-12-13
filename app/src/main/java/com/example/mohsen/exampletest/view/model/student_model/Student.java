package com.example.mohsen.exampletest.view.model.student_model;

import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private String familyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public static ArrayList<Student> getStudents(int numberOfStudents) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            Student student=new Student();
            student.setStudent(i,student);
            students.add(student);
        }
        return students;

    }

    public Student() {
    }

    public Student(int id) {
        this.id = id;

    }
    public Student setStudent(int id,Student student){
        student.setId(id + 1);
        student.setName("student number " + (id + 1));
        student.setFamilyName("family" + (id + 1));
        return student;
    }
}
