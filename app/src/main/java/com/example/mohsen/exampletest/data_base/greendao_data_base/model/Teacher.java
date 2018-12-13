package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class Teacher {
    @Id(autoincrement = true)
    private Long id;
    private String firstName;
    private String familyName;
    private Long schoolId;
    @Generated(hash = 608161506)
    public Teacher(Long id, String firstName, String familyName, Long schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.schoolId = schoolId;
    }
    @Generated(hash = 1630413260)
    public Teacher() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFamilyName() {
        return this.familyName;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public Long getSchoolId() {
        return this.schoolId;
    }
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

   

}
