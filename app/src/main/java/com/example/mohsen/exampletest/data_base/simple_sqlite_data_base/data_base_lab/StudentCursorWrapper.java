package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.Grade;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.Lesson;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

class StudentCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public StudentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Student getStudent() {
        String stringUUID = getString(getColumnIndex(SchoolDbSchema.StudentTable.Cols.UUID));
        String firstName = getString(getColumnIndex(SchoolDbSchema.StudentTable.Cols.FIRST_NAME));
        String familyName = getString(getColumnIndex(SchoolDbSchema.StudentTable.Cols.FAMILY_NAME));
        long studentNumber = getLong(getColumnIndex(SchoolDbSchema.StudentTable.Cols.STUDENT_NUMBER));
        String lessonsString = getString(getColumnIndex(SchoolDbSchema.StudentTable.Cols.STUDENT_LESSONS));
        String gradesString = getString(getColumnIndex(SchoolDbSchema.StudentTable.Cols.STUDENT_GRADES));
        Student student = new Student();
        student.setId(UUID.fromString(stringUUID));
        student.setFirstName(firstName);
        student.setFamilyName(familyName);
        student.setStudentNumber(studentNumber);
        student.setLessons(getLessonsArray(lessonsString));
        student.setGrades(getGradesArray(gradesString));
        return student;
    }

    private ArrayList<Lesson> getLessonsArray(String lessonsListString) {
        Type type = new TypeToken<ArrayList<Lesson>>() {
        }.getType();
        Gson gson = new Gson();
        ArrayList<Lesson> arrayList = new ArrayList<>();
        arrayList = gson.fromJson(lessonsListString, type);

        return arrayList;
    }

    private ArrayList<Grade> getGradesArray(String gradesListString) {
        Type type = new TypeToken<ArrayList<Grade>>() {
        }.getType();
        Gson gson = new Gson();
        ArrayList<Grade> arrayList = new ArrayList<>();
        arrayList = gson.fromJson(gradesListString, type);
        return arrayList;

    }
}
