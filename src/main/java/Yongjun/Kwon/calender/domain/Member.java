package Yongjun.Kwon.calender.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String birth;
    private String phoneNumber;

    protected Member() {
    }

    public Member(String name, String birth, String phoneNumber) {
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }
}
