package com.kh.totalJpaSample.controller;
import com.kh.totalJpaSample.dto.MemberDto;
import com.kh.totalJpaSample.entity.Member;
import com.kh.totalJpaSample.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kh.totalJpaSample.utils.Common.CORS_ORIGIN;

@Slf4j // Log f4 로그를 기록(필요한 이유: 오류(장애 발생) 잡을 때 로그에 기록이 남겨야 잡을 수 있기 때문, 파일 저장 시스템 필수), 출력하는 기능
@CrossOrigin(origins = CORS_ORIGIN)
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService; // MemberService 가져오기
    // 회원 등록
    @PostMapping("/new") // PostMapping은 무조건 RequestBody로 받아줌 걍 외워(스웨그를 사용해서 테스트하면 편리)
    public ResponseEntity<Boolean> memberRegister(@RequestBody MemberDto memberDto) {
        boolean isTrue = memberService.saveMember(memberDto);
        return ResponseEntity.ok(isTrue);
    }
    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDto>> memberList() {
        List<MemberDto> list = memberService.getMemberList();
        return ResponseEntity.ok(list);
    }
    // 회원 상세 조회
    @GetMapping("/detail/{email}") // 패스베리어블??
    public ResponseEntity<MemberDto> memberDetail(@PathVariable String email) {
        MemberDto memberDto = memberService.getMemberDetail(email);
        return ResponseEntity.ok(memberDto);
    }
}
