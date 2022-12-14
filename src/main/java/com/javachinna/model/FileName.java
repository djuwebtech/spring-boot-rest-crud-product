package com.javachinna.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "file_name2")
@DynamicUpdate
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class FileName implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "descendant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TreePath> parents = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ancestor")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TreePath> children = new ArrayList<>();

//    private int level;

    @Transient
    private String delimiter = "\\";

    public FileName() {

    }

    public FileName(String name, int level) {
        this.name = name;
//        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreePath> getParents() {
        return parents;
    }

    public void setParents(List<TreePath> parents) {
        this.parents = parents;
    }

    public List<TreePath> getChildren() {
        return children;
    }

    public void setChildren(List<TreePath> children) {
        this.children = children;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void addParent(TreePath p) {
        parents.add(p);
    }

    public void addChild(TreePath ch) {
        children.add(ch);
    }

    public void addParents(List<TreePath> p) {
        parents.addAll(p);
    }

    public void addChildren(List<TreePath> ch) {
        children.addAll(ch);
    }

//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }

}
