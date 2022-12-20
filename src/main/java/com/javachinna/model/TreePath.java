package com.javachinna.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tree_path2", indexes = {
        @Index(name = "IDX_ANCESTOR2", columnList = "ancestor"),
        @Index(name = "IDX_DESCENDANT2", columnList = "descendant")})
@DynamicUpdate
@IdClass(TreePathId.class)
public class TreePath implements Serializable{
    @Id
//    @JsonIgnore
    @ManyToOne(targetEntity = FileName.class)
    @JoinColumn(name = "ancestor", nullable = false, foreignKey = @ForeignKey(name = "FK_ANCESTOR"))
    @JsonIdentityReference(alwaysAsId = true)
    private FileName ancestor;

    @Id
//    @JsonIgnore
    @ManyToOne(targetEntity = FileName.class)
    @JoinColumn(name = "descendant", nullable = false, foreignKey = @ForeignKey(name = "FK_DESCENDANT"))
    @JsonIdentityReference(alwaysAsId = true)
    private FileName descendants;

    public TreePath() {

    }

    public TreePath(FileName ancestor, FileName descendant) {
        this.ancestor = ancestor;
        this.descendants = descendant;
    }

    public FileName getAncestor() {
        return ancestor;
    }

    public void setAncestor(FileName ancestor) {
        this.ancestor = ancestor;
    }

    public FileName getDescendant() {
        return descendants;
    }

    public void setDescendant(FileName descendant) {
        this.descendants = descendant;
    }

//    @Override
//    public String toString() {
//        return "TreePath{" + "ancestor=" + ancestor + ", descendant=" + descendant + '}';
//    }
}
