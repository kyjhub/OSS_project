package Yongjun.Kwon.calender.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Event {
    protected Event() {
    }

    public Event(Member member, String todo, LocalDateTime localDateTime) {
        this.member = member;
        this.todo = todo;
        this.localDateTime = localDateTime;
        this.eventStatus = EventStatus.INTENDED;
    }

    @Id @GeneratedValue
    @Column(name = "event_id")
    private Long id;
    private String todo;
    @NotBlank(message = "연월일이 없습니다.")
    private LocalDateTime localDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    public static Event createEvent(Member newMember, String newTodo) {
        Event newEvent = new Event(newMember, newTodo, LocalDateTime.now());
        return newEvent;
    }
}
