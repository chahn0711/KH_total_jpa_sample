package com.kh.totalJpaSample.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 프론트앤드와 연결하기 위해 주고 받기 위한 거
@Getter
@Setter
// Data Transfer Object : 계층간 데이터를 전송하기 위한 객체, 주로 프론트앤드와 JSON으로 통신하기 위한 객체
// 요청과 응답에 대한 객체
public class MemberDto {
    private String email;
    private String password;
    private String name;
    private LocalDateTime regData;
}
