package com.ieeeyesist12_2021.model;

import java.util.Date;

public class Event {
    private String eventName, aboutEvent, speakerName, speakerQualification, eventUrl;
    private Integer imageurl;
    private Date date, endDate;

    public Event(String eventName, String aboutEvent, String speakerName, String speakerQualification, String eventUrl, Integer imageurl, Date date, Date endDate) {
        this.eventName = eventName;
        this.aboutEvent = aboutEvent;
        this.speakerName = speakerName;
        this.speakerQualification = speakerQualification;
        this.eventUrl = eventUrl;
        this.imageurl = imageurl;
        this.date = date;
        this.endDate = endDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAboutEvent() {
        return aboutEvent;
    }

    public void setAboutEvent(String aboutEvent) {
        this.aboutEvent = aboutEvent;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerQualification() {
        return speakerQualification;
    }

    public void setSpeakerQualification(String speakerQualification) {
        this.speakerQualification = speakerQualification;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
