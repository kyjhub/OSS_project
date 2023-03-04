package Yongjun.Kwon.calender.controller;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.web.SessionConst;
import Yongjun.Kwon.calender.web.form.LoginForm;
import Yongjun.Kwon.calender.web.form.MemberForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
//    private final SessionManager sessionManager;

    /* @RequestMapping("/")
     public String home(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
         log.info("home controller");

         if (memberId == null) {
             model.addAttribute("memberForm", new MemberForm());
             model.addAttribute("loginForm", new LoginForm());
             return "home";
         }

         //로그인
         Member loginMember = memberRepository.findById(memberId);
         if (loginMember == null) {
             model.addAttribute("memberForm", new MemberForm());
             model.addAttribute("loginForm", new LoginForm());
             return "home";
         }

         return "/calendar";
     }*/
    /*@GetMapping("/")
    public String home(HttpServletRequest request, Model model) {

        log.info("home controller");
//        Member member = (Member)sessionManager.getSession(request);

        //세션이 없으면 home
        HttpSession session = request.getSession(false);
        if (session == null) {
            model.addAttribute("memberForm", new MemberForm());
            model.addAttribute("loginForm", new LoginForm());
            return "/home";
        }
        //세션에 회원 데이터가 없으면 home
        Member member = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (member == null) {
            model.addAttribute("memberForm", new MemberForm());
            model.addAttribute("loginForm", new LoginForm());
            return "/home";
        }

        //calender에 보낼 model있으면 추가

        log.info("direct login");
        return "/calendar";
    }*/
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
                       Model model) {
        if (loginMember == null) {
            model.addAttribute("memberForm", new MemberForm());
            model.addAttribute("loginForm", new LoginForm());
            return "/home";
        }
        log.info("direct login");
        return "/calendar";
    }
}
