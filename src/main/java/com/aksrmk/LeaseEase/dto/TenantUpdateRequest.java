package com.aksrmk.LeaseEase.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;


public class TenantUpdateRequest {

    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Nullable
    private String username;

    @Size(min = 6, message = "Password must be at least 6 characters")
    @Nullable
    private String password;

    @Size(max = 100, message = "Full name cannot exceed 100 characters")
    @Nullable
    private String fullName;

    @Past(message = "Date of birth must be in the past")
    @Nullable
    private LocalDate dateOfBirth;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Nullable
    private String phoneNumber;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Nullable
    private String address;

    @Size(max = 50, message = "Nationality cannot exceed 50 characters")
    @Nullable
    private String nationality;

    @Size(max = 10, message = "Gender cannot exceed 10 characters")
    @Nullable
    private String gender;

    @Nullable
    private LocalDate leaseStartDate;

    @Nullable
    private LocalDate leaseEndDate;

    @Size(min = 2, message = "pet name cannot be less than 2 characters")
    @Nullable
    private String petDetails;

    @Size(min = 2, message = "vehicle model cannot be less than 2 characters")
    @Nullable
    private String vehicleDetails;

    @Nullable
    public String getUsername() {
        return username;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    @Nullable
    public String getFullName() {
        return fullName;
    }

    @Nullable
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    @Nullable
    public String getNationality() {
        return nationality;
    }

    @Nullable
    public String getGender() {
        return gender;
    }

    @Nullable
    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    @Nullable
    public LocalDate getLeaseEndDate() { return leaseEndDate;}
    @Nullable
    public String getPetDetails() { return petDetails;}
    @Nullable
    public String getVehicleDetails() { return vehicleDetails;}
}
