package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.web.form.LoginForm;
import Yongjun.Kwon.calender.web.form.MemberForm;
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
        model.addAttribute("loginForm", new LoginForm());
        log.info("home controller");
        return "home";
    }
}
