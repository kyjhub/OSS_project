package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.service.EventService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @ResponseBody
    @PostMapping("/calender")
    public String addEvent(@ModelAttribute CreateEventRequest createEventRequest) {
        log.info("createEventRequest.todo= {}", createEventRequest.getTodo());
        log.info("createEventRequest.localDateTime= {}", createEventRequest.getLocalDateTime());
//        eventService.generateEvent()
        return "ok";
    }

    @Data
    static class CreateEventRequest {
        private String todo;
        @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime localDateTime;
//    private Member member;
    }

}
