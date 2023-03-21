package Yongjun.Kwon.calender.web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class EventForm {
    @NotBlank(message = "일정을 입력하지 않았습니다.")
    private String todo;
    @NotNull(message = "일정 시작일이 없습니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;
    @NotNull(message = "일정 마감일이 없습니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDateTime;

    public EventForm() {
    }
}
