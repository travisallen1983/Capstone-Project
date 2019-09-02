package org.launchcode.semesterassignmentflow.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Assignments {

    @Id
    @GeneratedValue
    private int assignmentId;
    private static int nextId = 1;
    private String type;
    private String details;
    private String course;
    private String due;

    @ManyToOne
    public Classes classes;

    public Assignments(){
        assignmentId = nextId;
        nextId++;
    }

    public Assignments(String course, String type, String details, String due){
        this.type = type;
        this.due = due;
        this.course= course;
        this.details = details;

    }

    public int getAssignmentId() {
        return assignmentId;
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
