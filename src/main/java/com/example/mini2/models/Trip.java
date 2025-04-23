package com.example.mini2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne
    private Captain captain;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "trip")
    private Payment payment;

    // Constructors
    public Trip() {}
    public Trip(LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Double getTripCost() {
        return tripCost;
    }
    public void setTripCost(Double tripCost) {
        this.tripCost = tripCost;
    }
    public Captain getCaptain() {
        return captain;
    }
    public void setCaptain(Captain captain) {
        this.captain = captain;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
