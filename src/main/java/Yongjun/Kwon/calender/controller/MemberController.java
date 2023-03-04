package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.service.MemberService;
import Yongjun.Kwon.calender.web.form.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    /* 회원가입 */
    @PostMapping("/members/new")
    public String create(@Validated MemberForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/home";
        }
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
