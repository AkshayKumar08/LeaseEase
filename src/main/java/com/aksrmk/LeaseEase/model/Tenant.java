package com.aksrmk.LeaseEase.model;

import com.aksrmk.LeaseEase.interfaces.User;
import com.aksrmk.LeaseEase.interfaces.UserBuilder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="tenant")
@Entity
public class Tenant implements User {
    @Id
    @Column(name = "tenant_id", nullable = false)
    private final String tenantId;
    private String username;
    private String password;
    private final String email;
    private String fullName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private String nationality;
    private String gender;
    private final String createdAt;
    private String updatedAt;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private String petDetails;
    private String vehicleDetails;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;


    public Tenant() {
        this.tenantId = UUID.randomUUID().toString();
        this.email = "leaseease@gmail.com";
        this.createdAt = LocalDateTime.now().toString();
    }
    // Private constructor to enforce the use of the builder
    private Tenant(Tenant.TenantBuilder builder) {
        this.tenantId = UUID.randomUUID().toString();
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.dateOfBirth = builder.dateOfBirth;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.nationality = builder.nationality;
        this.gender = builder.gender;
        this.updatedAt = this.createdAt = LocalDateTime.now().toString(); // Assigning current time
        this.leaseEndDate = builder.leaseStartDate;
        this.apartment = builder.apartment;
    }

    public String getId() {
        return this.tenantId;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }


    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNationality() {
        return this.nationality;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public LocalDate getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(LocalDate leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public String getPetDetails() {
        return petDetails;
    }

    public void setPetDetails(String petDetails) {
        this.petDetails = petDetails;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Apartment getApartment() {
        return this.apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    // TenantBuilder class implementing the UserBuilder interface
    public static class TenantBuilder implements UserBuilder {
        private String username;
        private String password;
        private final String email;
        private String fullName;
        private LocalDate dateOfBirth;
        private String phoneNumber;
        private String address;
        private String nationality;
        private String gender;
        private LocalDate leaseStartDate;
        private LocalDate leaseEndDate;
        private String petDetails;
        private String vehicleDetails;
        private Apartment apartment;


        // Required fields in the constructor
        public TenantBuilder(String username, String password, String email, LocalDate dateOfBirth) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
        }

        // Optional fields with setter methods
        public Tenant.TenantBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Tenant.TenantBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Tenant.TenantBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Tenant.TenantBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Tenant.TenantBuilder leaseStartDate(LocalDate leaseStartDate) {
            this.leaseStartDate = leaseStartDate;
            return this;
        }

        public Tenant.TenantBuilder leaseEndDate(LocalDate leaseEndDate) {
            this.leaseEndDate = leaseEndDate;
            return this;
        }

        public Tenant.TenantBuilder petDetails(String petDetails) {
            this.petDetails = petDetails;
            return this;
        }

        public Tenant.TenantBuilder vehicleDetails(String vehicleDetails) {
            this.vehicleDetails = vehicleDetails;
            return this;
        }

        public Tenant.TenantBuilder apartmentDetails(Apartment apartment) {
            this.apartment = apartment;
            return this;
        }

        @Override
        public String toString() {
            return "TenantBuilder{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", address='" + address + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", gender='" + gender + '\'' +
                    ", leaseStartDate=" + leaseStartDate +
                    ", leaseEndDate=" + leaseEndDate +
                    ", petDetails='" + petDetails + '\'' +
                    ", vehicleDetails='" + vehicleDetails + '\'' +
                    ", apartment='" + apartment + '\'' +
                    '}';
        }

        public Tenant.TenantBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        // Build method to create an instance of Tenant
        public Tenant build() {
            return new Tenant(this);
        }
    }
}
