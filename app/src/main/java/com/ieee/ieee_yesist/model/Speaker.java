package com.ieee.ieee_yesist.model;

public class Speaker {
    private String speakerName, speakerDesignation;
    private Integer speakerImage;

    public Speaker(String speakerName, String speakerDesignation, Integer speakerImage) {
        this.speakerName = speakerName;
        this.speakerDesignation = speakerDesignation;
        this.speakerImage = speakerImage;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerDesignation() {
        return speakerDesignation;
    }

    public void setSpeakerDesignation(String speakerDesignation) {
        this.speakerDesignation = speakerDesignation;
    }

    public Integer getSpeakerImage() {
        return speakerImage;
    }

    public void setSpeakerImage(Integer speakerImage) {
        this.speakerImage = speakerImage;
    }
}
