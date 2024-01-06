package com.aksrmk.LeaseEase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="apartment")
public class Apartment {

    public Apartment(){
        this.apartmentId = UUID.randomUUID().toString();
    }
    public Apartment(String address, int numberOfRooms, int numberOfBathrooms, Owner owner) {
        this();
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.owner = owner;
    }

    @Id
    @Column(name = "apartment_id", nullable = false)
    private final String apartmentId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int numberOfRooms;

    @Column(nullable = false)
    private int numberOfBathrooms;

    @Column(nullable = false)
    private double squareFootage;

    @Column(nullable = false)
    private boolean isFurnished;

    @ManyToOne(targetEntity = Owner.class)
    private Owner owner;

    @OneToMany(mappedBy = "apartment")
    private List<Tenant> tenants = new ArrayList<>();

    public String getApartmentId() {
        return apartmentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }


    public void setOwnerId(Owner owner) {
        this.owner = owner;
    }

    public List<Tenant> getTenants() { return tenants; }

    public void setTenant(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

