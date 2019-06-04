package com.example.springboot.sandbox.controller;

import com.example.springboot.sandbox.service.OtpDto;
import com.example.springboot.sandbox.service.OtpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * https://zero-gravity.tistory.com/221
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class OtpController {

    private final OtpService otpService;

    @GetMapping("/otp")
    public String otp(Model model) {
        final OtpDto generate = otpService.generate();
        model.addAttribute("encodedKey", generate.getEncodedKey());
        model.addAttribute("url", generate.getUrl());
        return "otp";
    }

    @PostMapping("/otpTestResult")
    public String test(@RequestParam("userCode") String userCodeStr,
                       @RequestParam String encodedKey,
                       Model model) {
        long userCode = Integer.parseInt(userCodeStr);
        boolean isOk = otpService.checkCode(encodedKey, userCode);
        log.info("otpTestResult: {}", isOk);
        model.addAttribute("isTestPassed", isOk);
        return "otpTest";
    }


}
