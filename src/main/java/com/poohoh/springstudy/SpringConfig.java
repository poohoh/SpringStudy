package com.poohoh.springstudy;

import com.poohoh.springstudy.repository.JdbcMemberRepository;
import com.poohoh.springstudy.repository.JdbcTemplateMemberRepository;
import com.poohoh.springstudy.repository.MemberRepository;
import com.poohoh.springstudy.repository.MemoryMemberRepository;
import com.poohoh.springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


/** 자바 코드로 직접 스프링 빈 설정하는 방법
* */

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
