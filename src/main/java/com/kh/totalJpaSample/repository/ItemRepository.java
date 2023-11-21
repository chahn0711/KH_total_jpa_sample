package com.kh.totalJpaSample.repository;
import com.kh.totalJpaSample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;


// 인터페이스로 필수로 바꿔야함(인터페이스란 상속 받는 것 / JpaRepository는 인터페이스로 상속 받는 것?? 상속 받는 대상은 하이버네이트
@Repository // 빈으로 등록 후 사용해야하는데 동작은 가능(명시적)
// 기본적인 CRUD는 JpaRepository에 이미 정의 되어 있음, 페이징 처리도 포함 되어 있음
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemName); // 필드 이름 동일해야함
    // OR 조건 처리
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
    // LessThan 조건 처리 : price 변수 보다 작은 상품 데이터 조회 하는 쿼리
    List<Item> findByPriceLessThan(Integer price);
    // OrderBy로 정렬 하기
    List<Item> findAllByOrderByPriceDesc(); // 내림순 정렬
    // JPQL 쿼리 작성 하기 : SQL 유사한 객체지향 쿼리 언어
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> priceSorting(@Param("itemDetail") String itemDetail);

    // nativeQuery 사용 카멜표기 안먹는 구간이라서 item_detail
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> priceSortingNative(@Param("itemDetail") String itemDetail);
}
