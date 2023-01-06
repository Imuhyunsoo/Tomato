package com.example.tomato.service;

import com.example.tomato.vo.MemberVO;

import java.util.List;

public interface MemberService {

    void join(MemberVO memberVO);   // 회원가입 서비스
    int id_confirm(String userid);   // 아이디 중복 확인 서비스
    int nickname_confirm(String userNickname);   // 닉네임 중복 확인 서비스
    List<String> sidoNameList();   // 시/도 명 리스트 가져오는 서비스
    List<String> sigunguNameList(String sidoName);   // 해당 시/도 데이터에 포함되는 시/군/구 리스트를 가져오는 서비스
    List<String> dongNameList(String sidoName, String dongName);   // 해당 시/도 및 시/군/구 데이터에 포함되는 동 리스트를 가져오는 서비스
}
