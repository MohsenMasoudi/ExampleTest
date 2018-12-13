package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ClassMark {
    @Id(autoincrement = true)
    private Long id;
    private Long gradeId;
    private int mark;
    @Generated(hash = 1785155463)
    public ClassMark(Long id, Long gradeId, int mark) {
        this.id = id;
        this.gradeId = gradeId;
        this.mark = mark;
    }
    @Generated(hash = 1120240438)
    public ClassMark() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getGradeId() {
        return this.gradeId;
    }
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
    public int getMark() {
        return this.mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }




}
