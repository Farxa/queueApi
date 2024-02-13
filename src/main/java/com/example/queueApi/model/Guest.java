package com.example.queueApi.model;

import javax.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "queue_id")
    private Queue queue;

    // Constructors, Getters, and Setters
    public void setQueue(Queue queue) {
        this.queue = queue;
    }
}
