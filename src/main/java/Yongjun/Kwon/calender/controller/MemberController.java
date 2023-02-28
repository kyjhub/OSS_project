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
        log.info("membercontroller postmapping");

        String id = form.getId();
        String password = form.getPassword();
        String phoneNumber = form.getPhoneNumber();
        String name = form.getName();
        // 집에서 form에 input요소 개수 늘려도 정상 작동되면
        // 회원가입할 떄 이름도 입력하도록 바꾸자.
        Member member = new Member(id, password, name, phoneNumber);

        memberService.join(member);

        return "redirect:/";
    }

}
