package Yongjun.Kwon.calender.service;

import Yongjun.Kwon.calender.domain.Event;
import Yongjun.Kwon.calender.domain.Member;
import Yongjun.Kwon.calender.repository.EventRepository;
import Yongjun.Kwon.calender.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {
    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;

    /* 일정 생성 */
    public Long generateEvent(String memberId, String todo) {
        Member member = memberRepository.find(memberId);
        Event event = Event.createEvent(member, todo);

        eventRepository.save(event);
        return event.getId();
    }

    /*일정 취소*/
    public void deleteEvent(Long eventId) {
        eventRepository.delete(eventId);
    }
}
