package com.aksrmk.LeaseEase.dto;

import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.model.Tenant;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.util.List;


public class ApartmentUpdateRequest {

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Column(name = "address")
    private String address;

    @Min(value = 1, message = "Number of rooms must be at least 1")
    @Max(value = 100, message = "Number of rooms cannot exceed 100")
    @NotNull(message = "Number of rooms is required")
    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

    @Min(value = 1, message = "Number of bathrooms must be at least 1")
    @Max(value = 10, message = "Number of bathrooms cannot exceed 10")
    @NotNull(message = "Number of bathrooms is required")
    @Column(name = "number_of_bathrooms")
    private Integer numberOfBathrooms;

    @Min(value = 100, message = "Square footage must be at least 100")
    @NotNull(message = "Square footage is required")
    @Column(name = "square_footage")
    private Integer squareFootage;

    @NotNull(message = "Furnished status is required")
    @Column(name = "is_furnished")
    private Boolean isFurnished;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private List<Tenant> tenants;

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public Boolean getFurnished() {
        return isFurnished;
    }

    public Owner getOwner() {
        return owner;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    public List<Tenant> getTenants() { return tenants; }
}
