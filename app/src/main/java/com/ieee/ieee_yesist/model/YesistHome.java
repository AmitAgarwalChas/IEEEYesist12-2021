package com.ieee.ieee_yesist.model;

public class YesistHome {
    Integer quesName;
    Integer quesReason;

    public YesistHome(Integer quesName, Integer quesReason) {
        this.quesName = quesName;
        this.quesReason = quesReason;
    }

    public Integer getQuesName() {
        return quesName;
    }

    public void setQuesName(Integer quesName) {
        this.quesName = quesName;
    }

    public Integer getQuesReason() {
        return quesReason;
    }

    public void setQuesReason(Integer quesReason) {
        this.quesReason = quesReason;
    }
}
