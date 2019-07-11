package com.example.springboot.sandbox.naver.new31514;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallVO {
    private String carNum;
    @JsonProperty("callStatus")
    private String cCode;
    private String visitorPhone;
    private String cIndex;
    @JsonIgnore
    private String sName;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCCode() {
        return cCode;
    }

    public void setCCode(String cCode) {
        this.cCode = cCode;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public String getCIndex() {
        return cIndex;
    }

    public void setCIndex(String cIndex) {
        this.cIndex = cIndex;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }
}
