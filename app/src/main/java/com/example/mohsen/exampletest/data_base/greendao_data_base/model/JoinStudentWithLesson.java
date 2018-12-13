package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class JoinStudentWithLesson {
    @Id(autoincrement = true)
    private Long id;
    private Long studentId;
    private Long lessonId;
    @Generated(hash = 1712566778)
    public JoinStudentWithLesson(Long id, Long studentId, Long lessonId) {
        this.id = id;
        this.studentId = studentId;
        this.lessonId = lessonId;
    }
    @Generated(hash = 1433744875)
    public JoinStudentWithLesson() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getLessonId() {
        return this.lessonId;
    }
    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }



}
