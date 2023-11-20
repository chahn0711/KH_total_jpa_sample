package com.kh.totalJpaSample.service;
import com.kh.totalJpaSample.dto.MemberDto;
import com.kh.totalJpaSample.entity.Member;
import com.kh.totalJpaSample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // 해당 객체를 빈으로 등록 한번만 사용하기 때문에 빈 등록 장점은 객체 생성 필요없어 편리
@RequiredArgsConstructor // 매개변수가 전부 포함된 생성자를 자동으로 생성 해줌
public class MemberService {
    private  final MemberRepository memberRepository; // 생성자를 가지고 의존성 주입을 받는 입장
    // 회원 등록 MemberController과 짝
    public boolean saveMember(MemberDto memberDto) {
        // 이미 등록된 회원인지 확인하는 쿼리문
        boolean isReg = memberRepository.existsByEmail(memberDto.getEmail());
        if(isReg) return false; // 이미 가입되면 넘어가고 아니면 밑 문장실행(등록 될 경우 false)

        Member member = new Member(); // 여러번 사용해야 하기때문에 객체 생성
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setName(memberDto.getName());
        memberRepository.save(member);
        return true;
    }
    // 회원 전체 조회(외부에서 불러올거라 public)
    public List<MemberDto> getMemberList() {
        List<MemberDto> memberDtos = new ArrayList<>(); // 받아낼 객체
        List<Member> members = memberRepository.findAll(); // 의존성 배열에 한번에 담김??
        // 향상된 for문 member 객수만큼??
        for(Member member : members) {
        }
        return memberDtos;
    }
    // 회원 상세 조회
    public MemberDto getMemberDetail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("해당 회원이 존재하지 않습니다.")
        );
        return convertEntityToDto(member);
    }
    // 회원 엔티티를 DTO로 변환하는 메소드 만들기(내부에서만 사용 -> private)
    private MemberDto convertEntityToDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(member.getEmail());
        memberDto.setPassword(member.getPassword());
        memberDto.setName(member.getName());
        memberDto.setRegData(member.getRegDate());
        return memberDto;
    }
}

