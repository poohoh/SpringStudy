package com.poohoh.springstudy;

import com.poohoh.springstudy.repository.JpaMemberRepository;
import com.poohoh.springstudy.repository.MemberRepository;
import com.poohoh.springstudy.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/** 자바 코드로 직접 스프링 빈 설정하는 방법
* */

@Configuration
public class SpringConfig {

/*
    private final DataSource dataSource;
    private final EntityManager em;
*/

    private final MemberRepository memberRepository;

    public SpringConfig(/*DataSource dataSource, EntityManager em*/ MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
/*
        this.dataSource = dataSource;
        this.em = em;
*/

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }
*/
}
