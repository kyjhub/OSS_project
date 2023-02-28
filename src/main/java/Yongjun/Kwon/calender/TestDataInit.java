package Yongjun.Kwon.calender;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("111", "1234", "ㅇㅇㅇ", "01054587844"));
        memberRepository.save(new Member("222", "5678", "ㄴㄴㄴ", "01012345678"));
    }
}
