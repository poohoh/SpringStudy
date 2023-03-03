/*
package com.poohoh.springstudy;

import com.poohoh.springstudy.repository.MemberRepository;
import com.poohoh.springstudy.repository.MemoryMemberRepository;
import com.poohoh.springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


*/
/*
* 자바 코드로 직접 스프링 빈 설정하는 방법
* *//*



@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    
}
*/
