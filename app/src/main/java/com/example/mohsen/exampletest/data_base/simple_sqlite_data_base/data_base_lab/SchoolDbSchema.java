package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab;

public class SchoolDbSchema {
    public static final String NAME = "simple_data_base_school.db";
    public static final int VERSION = 1;

    public static final class SchoolTable {
        public static final String NAME = "School";
        public static final class Cols {
            public static final String ID = "ID";
            public static final String NAME = "Name";
            public static final String MANGER = "Manager";
            public static final String STUDENTS = "Students";
            public static final String TEACHERS = "Teachers";
        }
    }
    public static final class StudentTable {
        public static final String NAME = "Student";
        public static final class Cols {
            public static final String UUID = "UUID";
            public static final String FIRST_NAME = "FirstName";
            public static final String FAMILY_NAME = "FamilyName";
            public static final String STUDENT_NUMBER = "StudentNumber";
            public static final String STUDENT_LESSONS = "StudentLessons";
            public static final String STUDENT_GRADES = "StudentGrades";
        }
    }
}
