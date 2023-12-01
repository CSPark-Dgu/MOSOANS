package com.example.myseventhapp;

public class Schools {
    String school_name;
    int image_id;
    String school_url;

    public Schools(String school_name, int image_id, String school_url) {
        this.school_name = school_name;
        this.image_id = image_id;
        this.school_url = school_url;
    }

    public String getSchool_name() {
        return school_name;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getSchool_url() {
        return school_url;
    }


}
