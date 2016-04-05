package com.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexey.savchuk on 04.04.2016.
 */
@Entity
@Table(name="PROGRAMMER")
public class Programmer implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="PROGRAMMER_ID")
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    public Programmer() {


    }

    public Programmer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Project id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", Project=" + project + "]";
    }

}
