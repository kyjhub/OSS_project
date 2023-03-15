package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.service.MemberService;
import Yongjun.Kwon.calender.web.form.LoginForm;
import Yongjun.Kwon.calender.web.form.MemberForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    /* 회원가입 */
    @PostMapping("/members/new")
    public String create(@Valid @ModelAttribute MemberForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("애초에 회원가입 형식이 맞지 않음");
            model.addAttribute("loginForm", new LoginForm());
            return "/home";
        }
        log.info("회원가입");
        log.info("membercontroller = {}", form);

        Member member = createMember(form);
        memberService.join(member);

        return "redirect:/";
    }

    private static Member createMember(MemberForm form) {
        Member member = new Member(form.getLoginId(), form.getPassword(),
                form.getName(), form.getPhoneNumber());
        return member;
    }

}
