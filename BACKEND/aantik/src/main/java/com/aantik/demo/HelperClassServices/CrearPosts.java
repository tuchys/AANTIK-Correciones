package com.aantik.demo.HelperClassServices;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CrearPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String postedby;
   // @Column(columnDefinition = "TEXT")
    private String PostBody;
    private String idGeneration;
    private LocalDate createDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPostedby() {
        return postedby;
    }
    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }
    public String getPostBody() {
        return PostBody;
    }
    public void setPostBody(String postBody) {
        PostBody = postBody;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public String getIdGeneration() {
        return idGeneration;
    }
    public void setIdGeneration(String idGeneration) {
        this.idGeneration = idGeneration;
    }

    
}
