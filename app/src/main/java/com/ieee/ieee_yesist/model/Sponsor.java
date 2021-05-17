package com.ieee.ieee_yesist.model;

public class Sponsor {

    private String imgUrl, webUrl;

    public Sponsor(String imgUrl, String webUrl) {
        this.imgUrl = imgUrl;
        this.webUrl = webUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
