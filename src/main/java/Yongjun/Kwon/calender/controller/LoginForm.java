package Yongjun.Kwon.calender.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginForm {
//    @NotBlank(message = "생년월일을 입력하지 않았습니다.")
    @Size(max = 6)
    private String birth;
//    @NotBlank(message = "전화번호를 입력하지 않았습니다.")
    @Size(max = 11)
    private String phoneNumber;

    public LoginForm(String birth, String phoneNumber) {
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }
}
