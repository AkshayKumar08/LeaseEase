package com.aksrmk.LeaseEase.interfaces;


import java.time.LocalDate;

public interface User {

    String getUsername();
    void setUsername(String username);

    String getPassword();
    void setPassword(String password);

    String getEmail();

    String getFullName();
    void setFullName(String fullName);

    LocalDate getDateOfBirth();
    void setDateOfBirth(LocalDate dateOfBirth);

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);

    String getAddress();
    void setAddress(String address);

    String getNationality();
    void setNationality(String nationality);

    String getGender();
    void setGender(String gender);

    String getCreatedAt();

    String getUpdatedAt();
    void setUpdatedAt(String updatedAt);
}