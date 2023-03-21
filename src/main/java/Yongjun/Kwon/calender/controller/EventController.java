package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Event;
import Yongjun.Kwon.calender.domain.EventStatus;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.service.EventService;
import Yongjun.Kwon.calender.web.SessionConst;
import Yongjun.Kwon.calender.web.form.EventForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @ResponseBody
    @PostMapping("/calender")
    public String addEvent(@Valid @RequestBody EventForm eventform, BindingResult bindingResult, HttpServletRequest request) {
        log.info("eventform.todo= {}", eventform.getTodo());
        log.info("eventform.startDateTime= {}", eventform.getStartDateTime());
        log.info("eventform.endDateTime= {}", eventform.getEndDateTime());

        if (bindingResult.hasErrors()) {
            log.info("event controller bindingresult error");
            return "/calender";
        }

        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        Event event = Event.createEvent(member, eventform.getTodo(), eventform.getStartDateTime(),
                eventform.getEndDateTime(), EventStatus.RESERVATION);

        Long eventId = eventService.generateEvent(event);

        return "ok";
    }
}
