package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Grade {
    @Id(autoincrement = true)
    private Long id;
    private Long lessonId;
    private Long studentId;
    private int midTermMark;
    private int finalMark;
    @ToOne(joinProperty = "lessonId")
    private Lesson lesson;
    @ToMany(referencedJoinProperty = "gradeId")
    private List<ClassMark> classMarks;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 681281562)
    private transient GradeDao myDao;
    @Generated(hash = 910978680)
    public Grade(Long id, Long lessonId, Long studentId, int midTermMark,
            int finalMark) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.midTermMark = midTermMark;
        this.finalMark = finalMark;
    }
    @Generated(hash = 2042976393)
    public Grade() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getLessonId() {
        return this.lessonId;
    }
    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public int getMidTermMark() {
        return this.midTermMark;
    }
    public void setMidTermMark(int midTermMark) {
        this.midTermMark = midTermMark;
    }
    public int getFinalMark() {
        return this.finalMark;
    }
    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }
    @Generated(hash = 1079550820)
    private transient Long lesson__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 688473547)
    public Lesson getLesson() {
        Long __key = this.lessonId;
        if (lesson__resolvedKey == null || !lesson__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LessonDao targetDao = daoSession.getLessonDao();
            Lesson lessonNew = targetDao.load(__key);
            synchronized (this) {
                lesson = lessonNew;
                lesson__resolvedKey = __key;
            }
        }
        return lesson;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 601950609)
    public void setLesson(Lesson lesson) {
        synchronized (this) {
            this.lesson = lesson;
            lessonId = lesson == null ? null : lesson.getId();
            lesson__resolvedKey = lessonId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 677124768)
    public List<ClassMark> getClassMarks() {
        if (classMarks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClassMarkDao targetDao = daoSession.getClassMarkDao();
            List<ClassMark> classMarksNew = targetDao._queryGrade_ClassMarks(id);
            synchronized (this) {
                if (classMarks == null) {
                    classMarks = classMarksNew;
                }
            }
        }
        return classMarks;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1088949292)
    public synchronized void resetClassMarks() {
        classMarks = null;
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
    @Generated(hash = 1187286414)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGradeDao() : null;
    }


}
