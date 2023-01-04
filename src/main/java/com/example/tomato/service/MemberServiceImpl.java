package com.example.tomato.service;

import com.example.tomato.mapper.MemberMapper;
import com.example.tomato.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    // 유저 회원가입
    @Override
    public void join(MemberVO memberVO) {

        log.info("join() ..");

        memberMapper.insertMember(memberVO);
    }

    @Override
    public int id_confirm(String userid) {

        log.info("id_confirm() ..");

       return memberMapper.idCheck(userid);
    }
}
