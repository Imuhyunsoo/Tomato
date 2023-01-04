package com.example.tomato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AuthController {

    // http://localhost:8282/tomato/
    // 토마토 기본 홈페이지
    @GetMapping("/")
    public String home() {

        return "index";
    }

}
