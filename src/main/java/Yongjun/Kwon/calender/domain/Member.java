package Yongjun.Kwon.calender.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;

    protected Member() {
    }
    public static Member createMember() {
        return new Member();
    }

    public Member(String loginId, String password, String name, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
//==연관관계 메서드==//

}
