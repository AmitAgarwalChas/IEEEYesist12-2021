package com.ieeeyesist12_2021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Professional implements Parcelable {
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

    protected Professional(Parcel in) {
        name = in.readString();
        imageUrl = in.readInt();
        role = in.readString();
        bio = in.readString();
        linkedinUrl = in.readString();
    }

    public static final Creator<Professional> CREATOR = new Creator<Professional>() {
        @Override
        public Professional createFromParcel(Parcel in) {
            return new Professional(in);
        }

        @Override
        public Professional[] newArray(int size) {
            return new Professional[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageUrl);
        dest.writeString(role);
        dest.writeString(bio);
        dest.writeString(linkedinUrl);
    }
}
