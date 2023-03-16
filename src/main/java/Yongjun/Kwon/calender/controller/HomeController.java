package Yongjun.Kwon.calender.controller;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.web.SessionConst;
import Yongjun.Kwon.calender.web.form.LoginForm;
import Yongjun.Kwon.calender.web.form.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
                       Model model) {
        log.info("home controller");

        if (loginMember == null) {
            log.info("세션만료 or 재로그인 필요");
            model.addAttribute("memberForm", new MemberForm());
            model.addAttribute("loginForm", new LoginForm());
            return "/home";
        }
        log.info("direct login");
        return "/calendar";
    }

}
