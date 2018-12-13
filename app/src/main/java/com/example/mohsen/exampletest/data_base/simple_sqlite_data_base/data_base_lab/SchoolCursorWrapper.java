package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class SchoolCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public SchoolCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public School getSchool() {
        String id = getString(getColumnIndex(SchoolDbSchema.SchoolTable.Cols.ID));
        String name = getString(getColumnIndex(SchoolDbSchema.SchoolTable.Cols.NAME));
        String manager = getString(getColumnIndex(SchoolDbSchema.SchoolTable.Cols.MANGER));
        String studentListString = getString(getColumnIndex(SchoolDbSchema.SchoolTable.Cols.STUDENTS));
        String teachersListString = getString(getColumnIndex(SchoolDbSchema.SchoolTable.Cols.TEACHERS));
        School school = new School();
        school.setId(Integer.parseInt(id));
        school.setName(name);
        school.setManager(manager);
        school.setStudents(getStudentsArray(studentListString));
        school.setTeachers(getTeachersArray(teachersListString));
        return school;

    }

    private ArrayList<UUID> getStudentsArray(String studentsListString) {
        Type type = new TypeToken<ArrayList<UUID>>() {
        }.getType();
        Gson gson = new Gson();
        ArrayList<UUID> arrayList = new ArrayList<>();
        arrayList = gson.fromJson(studentsListString, type);
        return arrayList;
    }

    private ArrayList<Integer> getTeachersArray(String teachersListString) {
        Type type = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        Gson gson = new Gson();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = gson.fromJson(teachersListString, type);
        return arrayList;

    }
}
