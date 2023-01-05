package com.example.tomato.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 지금부터 하는것은 시큐리티 설정 클래스 만들기
@Configuration      // 이 클래스는 설정 파일인것을 알려 주고, 부모가 @Component + 설정
@EnableWebSecurity  // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨 (제일 밑에다가 import) 12개의 Filter 를 등록 한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 우선 CSRF 설정을 해제한다.
        // 초기 개발시만 해주는게 좋다.
        http.csrf().disable();

        // http.httpBasic();   // 로그인 폼
        http.formLogin()       // 개선된 로그인 폼
                .loginPage("/login")        // 로그인 페이지 경로
                .defaultSuccessUrl("/");    // 완료 후 이동하는 경로
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 계정을 만드는 과정(메모리에 임의로 넣어서 만든 방법) withUser = 아이디, password = 비밀번호, roles = 권한
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");


        // customUserDetailsService -> loadUserByUsername 호출
        // auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder()); // 암호화 된 계정만 로그인
    }
}
