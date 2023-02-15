package Yongjun.Kwon.calender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        log.info("home controller");
        return "home2";
    }
}
