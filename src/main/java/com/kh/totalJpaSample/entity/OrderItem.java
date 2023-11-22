package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "Order_id")
    private Order order;

    private int orderPrice;
    private int count;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "order") // 연관관계의 주인이 아님을 표시 함 mappedBy필수 내가 주인이 아니기 때문에 꼭 필요
    private List<OrderItem> orderItemList = new ArrayList<>(); // 만들어진 정보(아이템)만 출력 주인이 아니니까 만들어진 것만 가져올 수 있음
}
