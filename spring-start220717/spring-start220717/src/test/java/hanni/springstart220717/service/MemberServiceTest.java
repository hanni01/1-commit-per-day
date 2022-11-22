package hanni.springstart220717.service;

import hanni.springstart220717.domain.Member;
import hanni.springstart220717.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//test 자동 만들기 단축기 윈도우: ctrl+shift+T
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hellospring");
        member.setId(01l);
        //when
        memberService.create(member);

        Long saveId = memberService.getOne(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원체크() {
        //given
        Member member1 = new Member();
        member1.setName("hellospring");

        Member member2 = new Member();
        member2.setName("hellospring");

        //when
        memberService.create(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.create(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e)
//        {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        } 올 주석 crtl+spacebar+/

        //then
    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("라라");

        Member member2 = new Member();
        member2.setName("루루");

        memberService.create(member1);
        memberService.create(member2);

        List<Member> memberList = memberService.findMembers();

        assertThat(memberList.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setId(23L);

        memberService.create(member1);

        Member result = memberService.findOne(member1.getId()).get();

        assertThat(result).isEqualTo(member1);
    }
}