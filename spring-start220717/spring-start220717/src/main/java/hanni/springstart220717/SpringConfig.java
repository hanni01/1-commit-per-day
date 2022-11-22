package hanni.springstart220717;

import hanni.springstart220717.repository.MemberRepository;
import hanni.springstart220717.repository.MemoryMemberRepository;
import hanni.springstart220717.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //자바 코드로 직접 스프링 빈 등록하기
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
