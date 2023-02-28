package Yongjun.Kwon.calender.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CalenderController {
    @GetMapping("/calender")
    public String calender(Model model) {
        log.info("calender controller");
//        model.addAttribute("Event", new EventForm());
        return "calendar";
    }

 /*   @PostMapping("/calender")
    public*/
}
