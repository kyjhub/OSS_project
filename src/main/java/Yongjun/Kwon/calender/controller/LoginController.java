package Yongjun.Kwon.calender.controller;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.service.MemberService;
import Yongjun.Kwon.calender.web.SessionConst;
import Yongjun.Kwon.calender.web.form.LoginForm;
import Yongjun.Kwon.calender.web.form.MemberForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;

    /* 로그인 */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("애초에 로그인 형식이 맞지 않음");
            model.addAttribute("memberForm", new MemberForm());
            return "/home";
        }

        Member loginMember = memberService.login(form.getId(), form.getPassword());
        log.info("login? {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/home";
        }

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        //redirectURL 적용하면 return "redriect:" + redirectURL;
        return "/calendar";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
//        sessionManager.expire(request);
        log.info("logout");
        //세션을 삭제한다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/home";
    }
}
