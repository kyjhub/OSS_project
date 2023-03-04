package Yongjun.Kwon.calender.service;

import Yongjun.Kwon.calender.web.form.MemberForm;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.message.LoginMessage;
import Yongjun.Kwon.calender.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(Member member) {
        memberRepository.save(member);
    }

    /*전화번호 중복 회원 검증*/
    private void validateIsNullPhoneNumber(String phoneNumber) {
        List<String> allPhoneNumber = memberRepository.findAllPhoneNumber();
        if (!allPhoneNumber.contains(phoneNumber)) {
            throw new IllegalStateException("가입된 전화번호가 없습니다.");
        }
    }
    /**
     * @return null이면 로그인 실패
     */
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /*전화번호 중복 확인 때문에 필요*/
    public List<String > findAllPhoneNumber() {
        return memberRepository.findAllPhoneNumber();
    }
}
