package org.launchcode.semesterassignmentflow.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String email;
    private String password;

   @OneToMany
   @JoinColumn
   public List<Classes> classes = new ArrayList<>();

    public User(){
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

    }

