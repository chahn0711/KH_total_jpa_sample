package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member") // 필수는 아닌데 이름 적는건 관례 안 적으면 임의로 소문자로 바뀜, 카멜 표기법으로 쓰면 X
@Getter @Setter @ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // AUTO는 스트링부트에 자동 생성
    @Column(name = "member_id")
    private Long id;

    private String userId;

    @Column(nullable = false) // NULL을 허용하지 않음
    private String name;
    private String password;
    @Column(unique = true) // 유일한 값이어야 함
    private String email;
    private LocalDateTime regDate; // join은 mysql키워드이므로 쓰면 오류남
    @PrePersist // 데이터가 들어오면 실행 디비에 넣기 바로 직전에 자바에서 계산하고 들어가는것?
    public void prePersist() {
        regDate = LocalDateTime.now();
    }
}
