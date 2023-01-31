package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.message.LoginMessage;
import Yongjun.Kwon.calender.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form) {

        log.info("membercontroller postmapping");

        String name = form.getName();
        String birth = form.getBirth();
        String phoneNumber = form.getPhoneNumber();
        Member member = new Member(name, birth, phoneNumber);

        memberService.join(member);

        return "redirect:/";
    }

    @PostMapping("/members/login")
    public ModelAndView login(@Valid MemberForm form, ModelAndView mav) {

        mav.setViewName("/LoginMessage");
        LoginMessage loginMessage = memberService.login(form);
        mav.addObject("data", loginMessage);
        return mav;
    }

}
