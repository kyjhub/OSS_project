package Yongjun.Kwon.calender.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    protected Account() {
    }
    private String ID;
    @Id
    private String password;
}
