package com.ieeeyesist12_2021.model;

public class YesistHome {
    String quesName;
    Integer quesReason;

    public YesistHome(String quesName, Integer quesReason) {
        this.quesName = quesName;
        this.quesReason = quesReason;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public Integer getQuesReason() {
        return quesReason;
    }

    public void setQuesReason(Integer quesReason) {
        this.quesReason = quesReason;
    }
}
