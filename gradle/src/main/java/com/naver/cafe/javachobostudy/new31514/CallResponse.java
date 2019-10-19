package com.naver.cafe.javachobostudy.new31514;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CallResponse {
    private int count;
    private String name;
    private List<CallVO> list;

    public CallResponse(List<CallVO> data) {
        this.list = data;
        this.count = data.size();
        if (!data.isEmpty()) {
            this.name = data.get(0).getSName();
        }
    }

    public static CallResponse of(@NotNull List<CallVO> data) {
        return new CallResponse(data);
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public List<CallVO> getList() {
        return list;
    }
}
