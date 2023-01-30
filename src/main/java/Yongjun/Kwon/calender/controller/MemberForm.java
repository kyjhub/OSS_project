package Yongjun.Kwon.calender.controller;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    private String name;
    @NotBlank(message = "생년월일을 입력하지 않았습니다.")
    private String birth;
    @NotBlank(message = "전화번호를 입력하지 않았습니다.")
    private String phoneNumber;

    public MemberForm() {
    }
    public MemberForm(String name, String birth, String phoneNumber) {
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

}
