package com.ieee.ieee_yesist.model;

public class TrackList {
    String trackName;
    Integer imageUrl;

    public TrackList(String trackName, Integer imageUrl) {
        this.trackName = trackName;
        this.imageUrl = imageUrl;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
