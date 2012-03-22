package edu.uwp.cs.android.sco.entities;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table DISABILITY.
 */
public class Disability {

    private Long id;
    /** Not-null value. */
    private String name;
    private String info;
    private Integer rating;
    private long studentId;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Disability() {
    }

    public Disability(Long id) {
        this.id = id;
    }

    public Disability(Long id, String name, String info, Integer rating, long studentId) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.rating = rating;
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    // KEEP METHODS - put your custom methods here
    
    @Override
    public String toString() {
    	return "ID: " + id + ", NAME: " + name + ", RATING: " + rating + ", INFO: " + info;
    }
    
    // KEEP METHODS END

}
