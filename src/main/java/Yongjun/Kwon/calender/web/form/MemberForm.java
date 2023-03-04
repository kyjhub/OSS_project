package Yongjun.Kwon.calender.web.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    @NotBlank(message = "아이디를 입력하지 않았습니다.")
    private String loginId;
    @NotBlank(message = "비밀번호를 입력하지 않았습니다.")
    private String password;
    @NotBlank(message = "전화번호를 입력하지 않았습니다.")
    private String phoneNumber;
    @NotBlank(message = "이름을 입력하지 않았습니다.")
    private String name;

    public MemberForm() {
    }

    public MemberForm(String loginId, String password, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
