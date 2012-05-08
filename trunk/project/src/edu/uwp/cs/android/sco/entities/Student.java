package edu.uwp.cs.android.sco.entities;

import java.util.Date;
import java.util.List;

import android.util.Log;
import edu.uwp.cs.android.sco.entities.DaoSession;
import edu.uwp.cs.android.sco.entities.Disability;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table STUDENT.
 */
public class Student {

    private Long id;
    /** Not-null value. */
    private String fName;
    /** Not-null value. */
    private String lName;
    private String note;
    /** Not-null value. */
    private java.util.Date lastModified;
    private Integer disabilityLevel;

    /** Used to resolve relations */
    private DaoSession daoSession;

    /** Used for active entity operations. */
    private StudentDao myDao;

    private List<Disability> disabilities;
    private List<RelationCourseStudent> courses;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, String fName, String lName, String note, java.util.Date lastModified, Integer disabilityLevel) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.note = note;
        this.lastModified = lastModified;
        this.disabilityLevel = disabilityLevel;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getFName() {
        return fName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /** Not-null value. */
    public String getLName() {
        return lName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /** Not-null value. */
    public java.util.Date getLastModified() {
        return lastModified;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getDisabilityLevel() {
        return disabilityLevel;
    }

    public void setDisabilityLevel(Integer disabilityLevel) {
        this.disabilityLevel = disabilityLevel;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<Disability> getDisabilities() {
        if (disabilities == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DisabilityDao targetDao = daoSession.getDisabilityDao();
            disabilities = targetDao._queryStudent_Disabilities(id);
        }
        return disabilities;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetDisabilities() {
        disabilities = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<RelationCourseStudent> getCourses() {
        if (courses == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RelationCourseStudentDao targetDao = daoSession.getRelationCourseStudentDao();
            courses = targetDao._queryStudent_Courses(id);
        }
        return courses;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetCourses() {
        courses = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    
    public Student(Long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.note = "";
        this.lastModified = new java.util.Date();
        this.disabilityLevel = 0;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", NAME: " + fName + " " + lName + "\n DISABILITIES: " + disabilities;
    }
    
    public void addDisability(Disability disability) {
    	disabilities = getDisabilities();
        disabilities.add(disability);
        daoSession.insert(disability);
    }
    
    public void addDisability(String name, String info, String category,  long studentId) {
        Disability dis = new Disability(null, name, info, 0, category, id);
        disabilities = getDisabilities();
        disabilities.add(dis);
        daoSession.insert(dis);
    }
    
    public void addDefaultDisabilities() {
    	String defaultInfo = "Lorem ipsum dolor sit amet, semper gravida.";
        addDisability("Concentration", defaultInfo, "General", id);
        addDisability("Understanding", defaultInfo, "General", id);
        addDisability("Repeating Content", defaultInfo, "General", id);
        addDisability("Panic attacks", defaultInfo, "General", id);
        addDisability("Spoken Words", "Problems to distinguish, identify or separate the sounds in spoken words.", "Speaking", id);
        addDisability("Letters", "Problems recognizing the sounds associated with letters and blend the sounds together to recognize a word.", "Speaking", id);
        addDisability("Translating", "Problems translating printed words into spoken words.", "Speaking", id);
        addDisability("Math facts", "Problems to remember and/or retrieve math facts", "Math", id);
        addDisability("Math operations", "Confused with math operations", "Math", id);
        addDisability("Math language processing", "Difficulties in language processing that may affect the ability to complete math problem solving", "Math", id);
    }
    
    public void deleteRelation(List<Long> courseRelations) {
        disabilities = getDisabilities();
        for (int i = 0; i < disabilities.size(); i++) {
            Disability dis = disabilities.get(i); 
            
            if (dis.getStudentId() == id) {
                daoSession.delete(dis);
                disabilities.remove(dis);
                i--;
            }
        }
        
        for (Long key : courseRelations) {
        	deleteRelation(key);
		}        
    }
    
    public void deleteRelation(long relationId) {
    	daoSession.getRelationCourseStudentDao().deleteByKey(relationId);
    	// TODO - delete element from courses too ??? or requery the cursor, adapter etc.
    }
    
    public void updateDisabilities(List<Disability> disUp, String note, Integer totalRating){
    	for (int i=0; i<disUp.size(); i++){
    		daoSession.getDisabilityDao().update(disUp.get(i));
    	}
    	
    	
    	if (totalRating<10){
    		disabilityLevel=0;
    	} 	
    	if (totalRating>=10){
    		disabilityLevel=1;
    	}
    	if (totalRating>=20){
    		disabilityLevel=2;
    	}
    	if (totalRating>=30){
    		disabilityLevel=3;
    	}
    	this.note = note;
    	disabilities = disUp;
    	lastModified = new Date();
    	daoSession.update(this);
    }
    
    // KEEP METHODS END

}
