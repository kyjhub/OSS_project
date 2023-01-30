package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.message.LoginFailMessage;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.message.LoginSuccessMessage;
import Yongjun.Kwon.calender.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        log.info("member login start");
        List<String> allPhoneNumber = memberService.findAllPhoneNumber();
        String requestPhoneNumber = form.getPhoneNumber();
        mav.setViewName("/LoginMessage");

        try {
            if (!allPhoneNumber.contains(requestPhoneNumber)) {
                throw new IllegalStateException("생년월일 또는 전화번호가 올바르지 않습니다.");
            }
            LoginSuccessMessage loginSuccessMessage = new LoginSuccessMessage("회원가입 되었습니다.", "/calender");
            mav.addObject("data", loginSuccessMessage);
            log.info("member login almost success");
            return mav;

        } catch (IllegalStateException e) {
            log.info("member login almost fail");
            LoginFailMessage loginFailMessage = new LoginFailMessage("생년월일 또는 전화번호가 올바르지 않습니다.", "/");
            e.printStackTrace();
            mav.addObject("data", loginFailMessage);
            return mav;
        }
    }

}
