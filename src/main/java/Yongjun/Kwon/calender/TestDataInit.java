package Yongjun.Kwon.calender;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.repository.MemberRepository;
import Yongjun.Kwon.calender.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberService memberService;
    @PostConstruct
    public void init() {
        memberService.join(new Member("1234", "1234", "ㅇㅇㅇ", "01012345678"));
        memberService.join(new Member("5678", "5678", "ㄴㄴㄴ", "01056781234"));
    }
}
