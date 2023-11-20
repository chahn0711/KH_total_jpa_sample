package com.kh.totalJpaSample.repository;
import com.kh.totalJpaSample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 스프링 컨테이너 빈 객체로 지정 -> 싱글톤 등록 Long ID타입 롱으로 하고 들어가는거 추천
// 네이밍 규칙에 의해서 API를 작성하면 그에 맞는 쿼리문을 Hibernate가 구현 해줌, JPA의 구현체??
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email); // 쿼리문 생성(Hibernate가 자동으로 만들어줌 "완벽한 카멜표기", 인터페이스에 생성해야 가능-개체지향문법 복습, Option를 사용하면 null처리해줌)
    Member findByPassword(String pwd);
    Member findByEmailAndPassword(String email, String pwd); // 이메일과 패스워드 찾아주는 쿼리
    boolean existsByEmail(String email);
}
