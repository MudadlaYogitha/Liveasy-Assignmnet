package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loads")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Auto-generate UUID
    @Column(name = "load_id", updatable = false, nullable = false)
    private UUID loadId;

    @Embedded
    private Facility facility;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "truck_type", nullable = false)
    private String truckType;

    @Column(name = "no_of_trucks", nullable = false)
    private int noOfTrucks;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "shipper_id", nullable = false)
    private UUID shipperId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    // Default Constructor
    public Load() {}

    // Parameterized Constructor
    public Load(UUID loadId, Facility facility, String productType, String truckType, int noOfTrucks, 
                double weight, String comment, UUID shipperId, LocalDateTime date) {
        this.loadId = loadId;
        this.facility = facility;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.shipperId = shipperId;
        this.date = date;
    }

    // Getters and Setters
    public UUID getLoadId() {
        return loadId;
    }

    public void setLoadId(UUID loadId) {
        this.loadId = loadId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(int noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UUID getShipperId() {
        return shipperId;
    }

    public void setShipperId(UUID shipperId) {
        this.shipperId = shipperId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
