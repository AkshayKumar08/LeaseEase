package com.aksrmk.LeaseEase.interfaces;

public interface UserBuilder {
    UserBuilder fullName(String fullName);
    UserBuilder phoneNumber(String phoneNumber);
    UserBuilder address(String address);
    UserBuilder nationality(String nationality);
    UserBuilder gender(String gender);
    User build();
}

