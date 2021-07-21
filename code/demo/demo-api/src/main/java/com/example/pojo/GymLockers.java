package com.example.pojo;

import java.io.Serializable;

public class GymLockers implements Serializable {
    private Long id;

    private String gymLockersLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGymLockersLocation() {
        return gymLockersLocation;
    }

    public void setGymLockersLocation(String gymLockersLocation) {
        this.gymLockersLocation = gymLockersLocation == null ? null : gymLockersLocation.trim();
    }
}