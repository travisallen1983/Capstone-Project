package org.launchcode.semesterassignmentflow.models;


import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

//@Entity
public class Classes {
    //@Id
    //@GeneratedValue

    private int id;

    @NotNull
    @Size(min=3, max=15 )
    private String name;
    private String number;
    private String semester;



   public Classes(){}

   public Classes(String name, String semester, String number){
        this.name = name;
        this.semester = semester;
        this.number = number;
    }

    public int getId() {
        return id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
