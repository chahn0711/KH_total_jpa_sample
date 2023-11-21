package com.kh.totalJpaSample.entity;

import com.kh.totalJpaSample.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
// lombok에서 제공
@Getter
@Setter
@ToString
@Entity // 클래스를 Entity로 선언(중요)
@Table(name = "item") // 엔티티(클래스 문법)와 매핑할 테이블을 지정(문법이 상이해 이름이 헷갈리지 않게 지정해주는 것) 생성된 테이블 이름 지정
public class Item {
    @Id // 테이블의 기본 키 지정
    @Column(name = "item_id") // 필드와 컬럼을 매핑(사용할 때는 id 그대로 사용하지만 테이블에 작성 될 때에는 지정한 이름으로 생성)
    @GeneratedValue(strategy = GenerationType.AUTO) // 특별한 경우 아님 디폴트, JPA구현체(하이버네이트)가 자동으로 생성 전략 결정(디비한테 위임)
    private Long id; // 상품 코드

    @Column(nullable = false, length = 50) // NULL을 허용하지 않고 길이를 50자로 제한
    private String itemName; // 상품명, 지정x -> item_name

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false) // NULL 허용 불가
    private int stockNumber; // 재고 수량

    @Lob // BLOB, CLOB 타입 매핑
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING) // enum으로 정의된 값을 문자열로 DB에 저장, STRING - 문자열 자체를 저장하는 것
    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간
}
