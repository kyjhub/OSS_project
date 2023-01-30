package Yongjun.Kwon.calender.service;

import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<String > findAllPhoneNumber() {
        return memberRepository.findAllPhoneNumber();

    }
}
