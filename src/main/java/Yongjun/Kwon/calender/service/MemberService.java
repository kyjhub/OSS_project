package Yongjun.Kwon.calender.service;

import Yongjun.Kwon.calender.controller.MemberForm;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.message.LoginMessage;
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

    /*전화번호 중복 회원 검증*/
    private void validateIsNullPhoneNumber(String phoneNumber) {
        List<String> allPhoneNumber = memberRepository.findAllPhoneNumber();
        if (!allPhoneNumber.contains(phoneNumber)) {
            throw new IllegalStateException("가입된 전화번호가 없습니다.");
        }
    }

    /*임시 로그인*/
    public LoginMessage login(MemberForm form) {
        String phoneNumber = form.getPhoneNumber();
        try {
            validateIsNullPhoneNumber(phoneNumber);
            LoginMessage loginsuccessMessage = new LoginMessage("로그인 되었습니다.", "/calender");
            return loginsuccessMessage;

        } catch (IllegalStateException e) {
            LoginMessage loginFailMessage = new LoginMessage("생년월일 또는 전화번호가 올바르지 않습니다.", "/");
            e.printStackTrace();
            return loginFailMessage;
        }
    }
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /*로그인 땜에 필요*/
    public List<String > findAllPhoneNumber() {
        return memberRepository.findAllPhoneNumber();

    }
}
