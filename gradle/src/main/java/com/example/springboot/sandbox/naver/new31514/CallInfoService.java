package com.example.springboot.sandbox.naver.new31514;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * mock data를 내려줌
 */
@Service
public class CallInfoService {
    public List<CallVO> callInfo(String s_name) {
        CallVO vo = new CallVO();
        vo.setCarNum("11111");
        vo.setCCode("code");
        vo.setVisitorPhone("011-1123-2222");
        vo.setCIndex("index");
        vo.setSName("namo");

        List<CallVO> result = new ArrayList<>();
        result.add(vo);
        return result;
    }
}
