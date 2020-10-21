package com.example.springboot.sandbox.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;

@Slf4j
@RestController
public class LimitationController {
    @GetMapping("/limitation")
    public int limitation(@RequestParam(defaultValue = "1") @Valid @Range(min = 1, max = 1000) @DecimalMax("1_000") int limit) {
        log.info("request: {}", limit);
        return limit;
    }

    @GetMapping("/limitation2")
    public int limitation2(@RequestBody @Valid LimitRequest request) {
        log.info("request: {}", request.limit);
        return request.limit;
    }

    @Getter
    @Setter
    public static class LimitRequest {
        @Range(min = 1, max = 1000, message = "limit.value")
//        @DecimalMax(value = "1_000", message = "limit 값은 1,000 이하여야 합니다.")
        private int limit;
    }
}
