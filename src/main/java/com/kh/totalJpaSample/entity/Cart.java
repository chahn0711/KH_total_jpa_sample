package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartName;

    @OneToOne // 회원 엔티티와 일대일 매핑
    @JoinColumn(name = "member_id") // 두개의 같은 컬럼 존재할 때
    private Member member; // 객체에 넣어줘야함?? 아이디는 자동생성이기 떄문에 필요 노
}
