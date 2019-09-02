package org.launchcode.semesterassignmentflow.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classes {
    @Id
    @GeneratedValue

    private int classId;
    private static int nextId = 1;

    @NotNull
    @Size(min=3, max=15 )
    private String name;
    private String description;
    private String semester;

    @ManyToOne
    public User user;

    @OneToMany
    @JoinColumn(name= "classes_id")
    private List<Assignments> assignments = new ArrayList<>();

   public Classes(){
       classId = nextId;
       nextId++;
   }

   public Classes(String name, String semester, String description){
        this.name = name;
        this.semester = semester;
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Assignments> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignments> assignments) {
        this.assignments = assignments;
    }
}
