package com.example.finalexam;

public class University {
    private String name;
    private String homepage;
    private String phoneNumber;
    private String email;
    private int imageUrl;

    public University(String name, String homepage, String phoneNumber, String email, int imageUrl) {
        this.name = name;
        this.homepage = homepage;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    // constructor, getters and setters
}