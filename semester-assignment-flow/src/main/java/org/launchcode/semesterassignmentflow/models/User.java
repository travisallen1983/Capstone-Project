package org.launchcode.semesterassignmentflow.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;

   @OneToMany
   public List<Classes> classes = new ArrayList<>();

    public User(){
    }

    public User(String name, String email, String password){
        this.name = name;
        this.email =email;
        this.password = password;
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

    public User(int id) {
        this.id = id;


    }
}
