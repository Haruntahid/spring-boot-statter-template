package com.example.practice.utils.commons;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUpdated;


    @PrePersist
    public void prePersist() {
        if (this.created == null) {
            this.created = new Date();
            this.lastUpdated = new Date();
        }
    }

    @PreUpdate
    private void onBaseUpdate() {
        this.lastUpdated = new Date();
    }
}
