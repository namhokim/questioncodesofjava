package com.example.springboot.sandbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://millky.com/@origoni/post/1144
 */
@Slf4j
@Controller
public class HelloTemplateController {

    @RequestMapping("/template")
    public String index(Model model) {
        model.addAttribute("name", "Spring Boot Template");
        return "hello";
    }
}
