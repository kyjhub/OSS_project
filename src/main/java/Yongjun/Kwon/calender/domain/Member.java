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
    @Id
    @Column(name = "member_id")
    private String id;
    private String password;
    private String name;
    private String phoneNumber;

    protected Member() {
    }

    public Member(String id, String password, String name, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
