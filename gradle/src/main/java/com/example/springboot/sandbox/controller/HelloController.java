package com.example.springboot.sandbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
//@Scope(value="request")
@RestController
public class HelloController {

    private final ConversionService conversionService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    public HelloController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @RequestMapping("/")
    public String hello(@RequestBody(required = false) @Valid FooDto fooDto, HttpServletRequest request) throws InterruptedException {
        log.info("request (autowired): {}, {}", httpServletRequest.hashCode(), httpServletRequest.toString());
        log.info("request (parameter): {}, {}", request.hashCode(), request.toString());
        Thread.sleep(3000);
        if (fooDto == null) {
            return "Need FooDto";
        }
        return "World: " + conversionService.convert(fooDto, String.class);
    }

    @PostMapping("/hello")
    public String hello1(@RequestBody User user) {
        log.info("request: {}", user);
        return user.toString();
    }

    /**
     * UserConverter 를 사용하여 변환된다.
     * {@link UserConverter}
     */
    @GetMapping("/hello2")
    public String hello2(@ModelAttribute("userId") User user) {
        log.info("request: {}", user);
        return "world";
    }

    /**
     * GET이지만 BODY가 있어야 에러가 안난다.
     */
    @GetMapping("/hello3")
    public String hello3(@RequestBody User user) {
        log.info("request: {}", user);
        return user.getUserId().toString();
    }
}
