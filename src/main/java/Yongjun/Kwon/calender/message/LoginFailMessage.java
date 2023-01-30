package Yongjun.Kwon.calender.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginFailMessage {
    private String message;
    private String href;

    public LoginFailMessage(String message, String href) {
        this.message = message;
        this.href = href;
    }
}
