package com.example.queueApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String id; // spotify userID

    private String displayName; // display name from spotify

    // Constructors
    public User() {
    }

    public User(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
