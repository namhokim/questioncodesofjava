package com.naver.cafe.javachobostudy.new31514;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallRequest {
    @JsonProperty("S_NAME")
    private String sName;

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }
}
