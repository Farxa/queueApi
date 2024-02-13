package com.example.queueApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    @Column(name = "owner")
    private String owner;
    @Column(name = "songs")
    private String[] songs;
    @Column(name = "guests")
    private String[] guests;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    public String[] getSongs() {
        return songs;
    }
    public String[] getGuests() {
        return guests;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setSongs(String[] songs) {
        this.songs = songs;
    }
    public void setGuests(String[] guests) {
        this.guests = guests;
    }

}
