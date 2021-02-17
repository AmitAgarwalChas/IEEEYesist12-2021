package com.ieeeyesist12_2021.model;

public class Professional {
    private String name;
    private int imageUrl;
    private String role;
    private String bio;
    private String linkedinUrl;

    public Professional(String name, int imageUrl, String role, String bio, String linkedinUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.role = role;
        this.bio = bio;
        this.linkedinUrl = linkedinUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}
