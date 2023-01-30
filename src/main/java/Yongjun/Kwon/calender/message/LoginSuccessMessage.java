package Yongjun.Kwon.calender.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginSuccessMessage {
    private String message;
    private String href;

    public LoginSuccessMessage(String message, String href) {
        this.message = message;
        this.href = href;
    }
}
