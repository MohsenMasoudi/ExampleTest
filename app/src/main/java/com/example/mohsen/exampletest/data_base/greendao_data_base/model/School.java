package com.example.mohsen.exampletest.data_base.greendao_data_base.model;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

@Entity
public class School {
    @Id(autoincrement = true)
    private Long  id;
    @NotNull
    private String name;
    @ToMany(referencedJoinProperty = "schoolId")
    private List<Student> students;
    @ToMany(referencedJoinProperty = "schoolId"  )
    private List<Teacher> teachers;
    private Long managerId;
    @ToOne(joinProperty = "id")
    private Manager manager;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1796006707)
    private transient SchoolDao myDao;
    @Generated(hash = 1462781442)
    public School(Long id, @NotNull String name, Long managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }
    @Generated(hash = 1579966795)
    public School() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getManagerId() {
        return this.managerId;
    }
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
    @Generated(hash = 66198253)
    private transient Long manager__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1957664914)
    public Manager getManager() {
        Long __key = this.id;
        if (manager__resolvedKey == null || !manager__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ManagerDao targetDao = daoSession.getManagerDao();
            Manager managerNew = targetDao.load(__key);
            synchronized (this) {
                manager = managerNew;
                manager__resolvedKey = __key;
            }
        }
        return manager;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1471480282)
    public void setManager(Manager manager) {
        synchronized (this) {
            this.manager = manager;
            id = manager == null ? null : manager.getId();
            manager__resolvedKey = id;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 262195125)
    public List<Student> getStudents() {
        if (students == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            List<Student> studentsNew = targetDao._querySchool_Students(id);
            synchronized (this) {
                if (students == null) {
                    students = studentsNew;
                }
            }
        }
        return students;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 238993120)
    public synchronized void resetStudents() {
        students = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 545952128)
    public List<Teacher> getTeachers() {
        if (teachers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeacherDao targetDao = daoSession.getTeacherDao();
            List<Teacher> teachersNew = targetDao._querySchool_Teachers(id);
            synchronized (this) {
                if (teachers == null) {
                    teachers = teachersNew;
                }
            }
        }
        return teachers;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 456331696)
    public synchronized void resetTeachers() {
        teachers = null;
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
    @Generated(hash = 234091322)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSchoolDao() : null;
    }

}
