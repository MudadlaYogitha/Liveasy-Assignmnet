package com.example.demo;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Embeddable
public class Facility {

    @Column(name = "loading_point")
    private String loadingPoint;

    @Column(name = "unloading_point")
    private String unloadingPoint;

    @Column(name = "loading_date")
    private Timestamp loadingDate;

    @Column(name = "unloading_date")
    private Timestamp unloadingDate;

    // Default constructor, getters, and setters
    public Facility() {}

    public Facility(String loadingPoint, String unloadingPoint, Timestamp loadingDate, Timestamp unloadingDate) {
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.loadingDate = loadingDate;
        this.unloadingDate = unloadingDate;
    }

    // Getters and setters
    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public Timestamp getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(Timestamp loadingDate) {
        this.loadingDate = loadingDate;
    }

    public Timestamp getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(Timestamp unloadingDate) {
        this.unloadingDate = unloadingDate;
    }
}
