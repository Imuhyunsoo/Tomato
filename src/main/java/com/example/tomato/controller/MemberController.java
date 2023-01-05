package com.example.tomato.controller;

import com.example.tomato.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/signup_view")
    public String signup_view(Model model) {

        log.info("signup_view() ..");

        List<String> sidoNames = new ArrayList<>();
        sidoNames = memberService.sidoNameList();

        model.addAttribute("sido_names", sidoNames);

        return "member/signup_view";
    }

}
