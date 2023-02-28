package Yongjun.Kwon.calender.repository;

import Yongjun.Kwon.calender.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member find(String Id) {
        return em.find(Member.class, Id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findById(String loginId) {
        return findAll().stream()
                .filter(m -> m.getId().equals(loginId))
                .findFirst();
    }

    public Member findByName(String Name) {
        return em.createQuery("select m from Member m where m.name=:name", Member.class)
                .setParameter("name", Name)
                .getSingleResult();
    }

    public Member findByPhoneNumber(String phoneNumber) {
        return em.createQuery("select m from Member m where m.phoneNumber=:phoneNumber", Member.class)
                .setParameter("phoneNumber", phoneNumber)
                .getSingleResult();
    }

    public List<String> findAllPhoneNumber() {
        return em.createQuery("select m.phoneNumber from Member m", String.class)
                .getResultList();
    }
}
