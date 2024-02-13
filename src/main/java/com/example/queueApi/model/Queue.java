package com.example.queueApi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "owner")
    private String owner;
    
    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Song> songs = new HashSet<>();
    
    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Guest> guests = new HashSet<>();


    public Set<Song> getSongs() {
        return songs;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void addSong(Song song) {
        songs.add(song);
        song.setQueue(this);
    }

    public void removeSong(Song song) {
        songs.remove(song);
        song.setQueue(null);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
        guest.setQueue(this);
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
        guest.setQueue(null);
    }
}
