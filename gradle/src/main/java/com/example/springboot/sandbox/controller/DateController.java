package com.example.springboot.sandbox.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RestController
public class DateController {
    @PostMapping("/date")
    public DateResult period(@RequestBody DateParam dateParam) {
        final DateResult result = DateResult.from(dateParam);
        log.info(result.toString());
        return result;
    }

    @PostMapping("/updateCalendar")
    public void updateCalendar(@RequestBody CalendarDTO calendar) {
        log.info("updateCalendar : {}", calendar);
    }
}

@Value
class DateResult {
    private final LocalDateTime start;
    private final LocalDateTime end;

    public DateResult(DateParam param) {
        this.start = param.getStart();
        this.end = param.getEnd();
    }

    static DateResult from(DateParam param) {
        return new DateResult(param);
    }
}

@Getter
@Setter
class DateParam {
    private LocalDateTime start;
    private LocalDateTime end;
}

@Data
class CalendarDTO {
    private Long cno;
    private String title;
    private Date start;
    private Date end;
    private String description;
    private String type;
    private String username;
    private String userid;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;
}