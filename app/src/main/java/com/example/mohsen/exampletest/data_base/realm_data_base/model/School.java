package com.example.mohsen.exampletest.data_base.realm_data_base.model;




import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class School extends RealmObject {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Student> getStudents() {
        return students;
    }

    public void setStudents(RealmList<Student> students) {
        this.students = students;
    }

    public RealmList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(RealmList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @PrimaryKey

    private Long  id;
    private String name;
    private RealmList<Student> students;
    private RealmList<Teacher> teachers;
    private Long managerId;
    private Manager manager;

}
