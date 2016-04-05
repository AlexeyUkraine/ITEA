package com.model;

import javax.persistence.*;
import javax.swing.text.StringContent;
import java.util.List;

/**
 * Created by alexey.savchuk on 04.04.2016.
 */
@Entity
@Table(name="Project")
public class Project {

    @Id
    @GeneratedValue
    @Column(name="PROJECT_ID")
    private long id;

    @Column(name="PROJ_TITLE")
    private String projTitle;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Programmer> programmers;

    public Project() {

    }

    public Project(String projTitle) {
        this.projTitle = projTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjTitle() {
        return projTitle;
    }

    public void setProjTitle(String projTitle) {
        this.projTitle = projTitle;
    }

    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(List<Programmer> programmers) {
        this.programmers = programmers;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projTitle=" + projTitle + "]";
    }
}
