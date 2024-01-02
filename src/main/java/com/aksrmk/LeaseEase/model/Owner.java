package com.aksrmk.LeaseEase.model;

import com.aksrmk.LeaseEase.interfaces.User;
import com.aksrmk.LeaseEase.interfaces.UserBuilder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class Owner implements User {
    @Id
    private final String ownerId;
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

    public Owner() {
        this.ownerId = UUID.randomUUID().toString();
        this.email = "leaseease@gmail.com";
        this.createdAt = LocalDateTime.now().toString();
    }
    // Private constructor to enforce the use of the builder
    private Owner(OwnerBuilder builder) {
        this.ownerId = UUID.randomUUID().toString();
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
    }

    public String getId() {
        return this.ownerId;
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

    // OwnerBuilder class implementing the UserBuilder interface
    public static class OwnerBuilder implements UserBuilder {
        private String username;
        private String password;
        private final String email;
        private String fullName;
        private LocalDate dateOfBirth;
        private String phoneNumber;
        private String address;
        private String nationality;
        private String gender;

        // Required fields in the constructor
        public OwnerBuilder(String username, String password, String email, LocalDate dateOfBirth) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
        }

        // Optional fields with setter methods
        public OwnerBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public OwnerBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public OwnerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public OwnerBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        @Override
        public String toString() {
            return "OwnerBuilder{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", address='" + address + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        public OwnerBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        // Build method to create an instance of Owner
        public Owner build() {
            return new Owner(this);
        }
    }
}
