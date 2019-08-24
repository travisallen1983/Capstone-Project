package org.launchcode.semesterassignmentflow.models;

public class Assignments {
    private int id;
    private String type;
    private String details;
    private String course;
    private String due;

    public Assignments(){}

    public Assignments(String course, String type, String details, String due){
        this.type = type;
        this.type = due;
        this.type = course;
        this.details = details;

    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }
}
