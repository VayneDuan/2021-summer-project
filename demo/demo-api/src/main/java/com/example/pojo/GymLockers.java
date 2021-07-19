package com.example.pojo;

public class GymLockers {
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