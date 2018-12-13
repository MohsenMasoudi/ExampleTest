package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class School {
    private Integer id;
    private String name;
    private ArrayList<UUID> students;
    private ArrayList<Integer> teachers;
    private String manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<UUID> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<UUID> students) {
        this.students = students;
    }

    public ArrayList<Integer> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Integer> teachers) {
        this.teachers = teachers;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public School() {
        Random random=new Random();
        this.id = Math.abs(random.nextInt());
    }
}
