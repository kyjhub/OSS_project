package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Event;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CalenderController {
    @GetMapping("/calender")
    public String calender(Model model) {
        log.info("calender controller");
//        model.addAttribute("Event", new EventForm());
        return "calender";
    }

 /*   @PostMapping("/calender")
    public*/
}
