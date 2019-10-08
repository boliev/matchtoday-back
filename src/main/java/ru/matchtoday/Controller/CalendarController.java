package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {

    private Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @RequestMapping("/")
    public String index() {
        // This is just test code
        return "Hey hey hey! This is your calendar maaaaan!";
    }

}