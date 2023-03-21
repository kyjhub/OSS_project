package Yongjun.Kwon.calender.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
public class Event {
    protected Event() {
    }

    public Event(String todo, LocalDateTime startDateTime, LocalDateTime endDateTime, Member member, EventStatus eventStatus) {
        this.todo = todo;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.member = member;
        this.eventStatus = eventStatus;
    }

    @Id @GeneratedValue
    @Column(name = "event_id")
    private Long id;
    private String todo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    public static Event createEvent(Member member, String newTodo,
                                    LocalDateTime startDateTime, LocalDateTime endDateTime, EventStatus eventStatus) {
        return new Event(newTodo, startDateTime, endDateTime, member, eventStatus);
    }
}
