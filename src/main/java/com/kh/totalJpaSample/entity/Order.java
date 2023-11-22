package com.kh.totalJpaSample.entity;

import com.kh.totalJpaSample.constant.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // order이 db 예약어로 걸려서 orders
// 생성만 하고 끝이라서 겟터 세터 x
public class Order {
    @Id
    @GeneratedValue // 기본 생성 전략은 Auto
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; // 회원이 주인

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
