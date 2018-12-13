package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SimpleDataBaseSchoolHelper extends SQLiteOpenHelper {


    public SimpleDataBaseSchoolHelper( Context context) {
        super(context, SchoolDbSchema.NAME, null, SchoolDbSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + SchoolDbSchema.SchoolTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                SchoolDbSchema.SchoolTable.Cols.ID +  "," +
                SchoolDbSchema.SchoolTable.Cols.MANGER + "," +
                SchoolDbSchema.SchoolTable.Cols.NAME + "," +
                SchoolDbSchema.SchoolTable.Cols.STUDENTS + "," +
                SchoolDbSchema.SchoolTable.Cols.TEACHERS  +
                ")");
        db.execSQL("create table " + SchoolDbSchema.StudentTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                SchoolDbSchema.StudentTable.Cols.UUID + "," +
                SchoolDbSchema.StudentTable.Cols.FIRST_NAME + "," +
                SchoolDbSchema.StudentTable.Cols.FAMILY_NAME + "," +
                SchoolDbSchema.StudentTable.Cols.STUDENT_LESSONS + "," +
                SchoolDbSchema.StudentTable.Cols.STUDENT_NUMBER + "," +
                SchoolDbSchema.StudentTable.Cols.STUDENT_GRADES  +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
