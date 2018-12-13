package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private Long schoolId;
    private String firstName;
    private String familyName;
    private long studentNumber;

    @ToMany
    @JoinEntity(
            entity = JoinStudentWithLesson.class,
            sourceProperty = "studentId",
            targetProperty = "lessonId"
    )
    private List<Lesson> lessons;
    @ToMany(referencedJoinProperty = "studentId")
    private List<Grade> grades;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 1650979958)
    public Student(Long id, Long schoolId, String firstName, String familyName,
            long studentNumber) {
        this.id = id;
        this.schoolId = schoolId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.studentNumber = studentNumber;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSchoolId() {
        return this.schoolId;
    }
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
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
    public long getStudentNumber() {
        return this.studentNumber;
    }
    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1227962242)
    public List<Lesson> getLessons() {
        if (lessons == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LessonDao targetDao = daoSession.getLessonDao();
            List<Lesson> lessonsNew = targetDao._queryStudent_Lessons(id);
            synchronized (this) {
                if (lessons == null) {
                    lessons = lessonsNew;
                }
            }
        }
        return lessons;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1769801440)
    public synchronized void resetLessons() {
        lessons = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1723003107)
    public List<Grade> getGrades() {
        if (grades == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GradeDao targetDao = daoSession.getGradeDao();
            List<Grade> gradesNew = targetDao._queryStudent_Grades(id);
            synchronized (this) {
                if (grades == null) {
                    grades = gradesNew;
                }
            }
        }
        return grades;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1194832572)
    public synchronized void resetGrades() {
        grades = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

}
