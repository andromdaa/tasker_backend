package com.colehoffman.reactbackend.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long Id;
    private String status;
    private String name;
    private String description;
    private String priority;

    public Task() {}

    public Task(Long id, String status, String name, String description) {
        Id = id;
        this.status = status;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public boolean setStatus(String status) {
        this.status = status;
        return true;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
