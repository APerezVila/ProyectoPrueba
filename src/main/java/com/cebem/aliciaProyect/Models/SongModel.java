package com.cebem.aliciaProyect.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "song")
public class SongModel {
    @Id
    @GeneratedValue
    @Column (unique = true, nullable = false)
    private Long id;
    private String name;
    private Integer duration;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
