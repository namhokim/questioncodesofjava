package com.naver.cafe.javachobostudy.new31514;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KioskController {

    private CallInfoService callInfoService;

    @Autowired
    public KioskController(CallInfoService callInfoService) {
        this.callInfoService = callInfoService;
    }

    @ResponseBody
    @PostMapping(value = "/kiosk/callinfo",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CallResponse callinfo(@RequestBody CallRequest callRequest) {

        final List<CallVO> callVo = callInfoService.callInfo(callRequest.getSName());
        return CallResponse.of(callVo);
    }
}
