package Yongjun.Kwon.calender.web.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    @NotBlank(message = "아아디를 입력해주세요")
    private String id;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    public LoginForm() {
    }
}
