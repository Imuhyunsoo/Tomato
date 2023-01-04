package com.example.tomato.controller;

import com.example.tomato.service.MemberService;
import com.example.tomato.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // http://localhost:8282/tomato/member/signup
    /* 클라이언트에서 회원가입 페이지 요청 받았을 경우 실행되는 메소드
       데이터 교환 형식은 JSON 형태로 작업한다. */
    @PostMapping("/id_confirm")
    public ResponseEntity<String> id_confirm(@RequestBody String userid) {

        log.info("id_confirm() ..");

        ResponseEntity<String> entity = null;

        System.out.println(userid);

        try {
            memberService.id_confirm(userid);   // 아이디 중복 검사 서비스 요청
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }


    // http://localhost:8282/tomato/member/signup
    /* 클라이언트에서 회원가입 페이지 요청 받았을 경우 실행되는 메소드
       데이터 교환 형식은 JSON 형태로 작업한다. */
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberVO memberVO) {

        log.info("User signup() ..");

        ResponseEntity<String> entity = null;

        System.out.println(memberVO);

        try {
            memberService.join(memberVO);   // 회원가입 서비스 요청
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
