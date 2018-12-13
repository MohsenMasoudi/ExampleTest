package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.Student;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class SchoolRepository {
    private static SchoolRepository schoolRepository;
    private SQLiteDatabase database;

    private SchoolRepository(Context context) {
        database = new SimpleDataBaseSchoolHelper(context.getApplicationContext()).getWritableDatabase();
    }

    public static SchoolRepository getInstance(Context context) {
        if (schoolRepository == null) {
            return new SchoolRepository(context);
        } else {
            return schoolRepository;
        }

    }

    private ContentValues getSchoolContentValues(School school) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchoolDbSchema.SchoolTable.Cols.ID, school.getId().toString());
        contentValues.put(SchoolDbSchema.SchoolTable.Cols.MANGER, school.getManager());
        contentValues.put(SchoolDbSchema.SchoolTable.Cols.NAME, school.getName());
        contentValues.put(SchoolDbSchema.SchoolTable.Cols.STUDENTS, changeArrayToString(school.getStudents()));
        contentValues.put(SchoolDbSchema.SchoolTable.Cols.TEACHERS, changeArrayToString(school.getTeachers()));
        return contentValues;
    }

    private ContentValues getStudentContentValues(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchoolDbSchema.StudentTable.Cols.FAMILY_NAME, student.getFamilyName());
        contentValues.put(SchoolDbSchema.StudentTable.Cols.FIRST_NAME, student.getFirstName());
        contentValues.put(SchoolDbSchema.StudentTable.Cols.UUID, student.getId().toString());
        contentValues.put(SchoolDbSchema.StudentTable.Cols.STUDENT_GRADES, changeArrayToString(student.getGrades()));
        contentValues.put(SchoolDbSchema.StudentTable.Cols.STUDENT_NUMBER, student.getStudentNumber());
        contentValues.put(SchoolDbSchema.StudentTable.Cols.STUDENT_LESSONS, changeArrayToString(student.getLessons()));
        return contentValues;
    }

    private String changeArrayToString(ArrayList arrayList) {
        Gson gson = new Gson();
        return gson.toJson(arrayList);
    }

    public void addSchool(School school) {
        ContentValues contentValues = getSchoolContentValues(school);
        database.insert(SchoolDbSchema.SchoolTable.NAME, null, contentValues);
    }

    public void addStudent(Student student) {
        ContentValues contentValues = getStudentContentValues(student);
        database.insert(SchoolDbSchema.StudentTable.NAME, null, contentValues);
    }

    public void updateSchool(School school) {
        ContentValues contentValues = getSchoolContentValues(school);
        database.update(SchoolDbSchema.SchoolTable.NAME,
                contentValues,
                SchoolDbSchema.SchoolTable.Cols.ID + "=?",
                new String[]{school.getId() + ""});
    }


    public void updateStudent(Student student) {
        ContentValues contentValues = getStudentContentValues(student);
        database.update(SchoolDbSchema.StudentTable.NAME,
                contentValues,
                SchoolDbSchema.StudentTable.Cols.UUID + "=?",
                new String[]{student.getId().toString()});
    }

    @NotNull
    private SchoolCursorWrapper querySchool(String whereClause, String[] whereArgs) {
        Cursor cursor = database.query(SchoolDbSchema.SchoolTable.NAME, null, whereClause, whereArgs, null, null, null);
        return new SchoolCursorWrapper(cursor);
    }

    @NotNull
    private StudentCursorWrapper queryStudent(String whereClause, String[] whereArgs) {
        Cursor cursor = database.query(SchoolDbSchema.StudentTable.NAME, null, whereClause, whereArgs, null, null, null);
        return new StudentCursorWrapper(cursor);
    }

    public boolean deleteSchool(School school) {
        String whereClause = SchoolDbSchema.SchoolTable.Cols.NAME + "=? AND " + SchoolDbSchema.SchoolTable.Cols.ID + "=?";
        String[] whereArgs = new String[]{school.getName(), school.getId() + ""};
        SchoolCursorWrapper schoolCursorWrapper = querySchool(whereClause, whereArgs);
        if (schoolCursorWrapper.getCount() == 0)
            return false;
        else {
            database.delete(SchoolDbSchema.SchoolTable.NAME, whereClause, whereArgs);
            return true;
        }
    }

    public boolean deleteStudent(Student student) {
        String whereClause = SchoolDbSchema.StudentTable.Cols.UUID + "=? ";
        String[] whereArgs = new String[]{student.getId().toString()};
        StudentCursorWrapper studentCursorWrapper = queryStudent(whereClause, whereArgs);
        if (studentCursorWrapper.getCount() == 0)
            return false;
        else {
            database.delete(SchoolDbSchema.StudentTable.NAME, whereClause, whereArgs);
            return true;
        }
    }

    public ArrayList<School> getSchools() {
        SchoolCursorWrapper schoolCursorWrapper = querySchool(null, null);
        ArrayList<School> schoolList = new ArrayList<>();
        if (schoolCursorWrapper.getCount() == 0)
            return schoolList;
        schoolCursorWrapper.moveToFirst();
        try {
            while (!schoolCursorWrapper.isAfterLast()) {
                School school = schoolCursorWrapper.getSchool();
                schoolList.add(school);
                schoolCursorWrapper.moveToNext();
            }
        } finally {
            schoolCursorWrapper.close();
        }
        return schoolList;
    }

    public ArrayList<Student> getStudents() {
        StudentCursorWrapper studentCursorWrapper = queryStudent(null, null);
        ArrayList<Student> studentList = new ArrayList<>();
        if (studentCursorWrapper.getCount() == 0)
            return studentList;
        studentCursorWrapper.moveToFirst();
        try {
            while (!studentCursorWrapper.isAfterLast()) {
                Student student = studentCursorWrapper.getStudent();
                studentList.add(student);
                studentCursorWrapper.moveToNext();
            }
        } finally {
            studentCursorWrapper.close();
        }
        return studentList;
    }

    public School getSchool(Integer schoolId) {
        String whereClause = SchoolDbSchema.SchoolTable.Cols.ID + "=?";
        String[] whereArgs = new String[]{
                String.valueOf(schoolId)
        };
        SchoolCursorWrapper schoolCursorWrapper = querySchool(whereClause, whereArgs);
        if (schoolCursorWrapper.getCount() == 0)
            return null;
        try {
            schoolCursorWrapper.moveToFirst();
            return schoolCursorWrapper.getSchool();
        } finally {
            schoolCursorWrapper.close();
        }
    }

    public Student getStudent(UUID studentID) {
        String whereClause = SchoolDbSchema.StudentTable.Cols.UUID + "=?";
        String[] whereArgs = new String[]{
                studentID.toString()
        };
        StudentCursorWrapper studentCursorWrapper = queryStudent(whereClause, whereArgs);
        if (studentCursorWrapper.getCount() == 0)
            return null;
        try {
            studentCursorWrapper.moveToFirst();
            return studentCursorWrapper.getStudent();
        } finally {
            studentCursorWrapper.close();
        }
    }
}
