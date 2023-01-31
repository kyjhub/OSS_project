package Yongjun.Kwon.calender.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginMessage {
    private String message;
    private String href;

    public LoginMessage(String message, String href) {
        this.message = message;
        this.href = href;
    }
}
