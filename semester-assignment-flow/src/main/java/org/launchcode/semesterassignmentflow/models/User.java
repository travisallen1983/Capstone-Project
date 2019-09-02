package org.launchcode.semesterassignmentflow.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private static int nextId = 1;
    private String name;
    private String email;
    private String password;
    private String semester;

   @OneToMany
   @JoinColumn(name= "user_id")
   public List<Classes> classes = new ArrayList<>();

    public User(){
        userId = nextId;
        nextId++;
    }

    public User(String name, String email, String password){
        this.name = name;
        this.email =email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}

