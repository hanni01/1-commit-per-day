package hanni.springstart220717.service;

import hanni.springstart220717.domain.Member;
import hanni.springstart220717.repository.MemberRepository;
import hanni.springstart220717.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired //의존성 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public String create(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getName()+"님이 가입에 성공하셨습니다.";
    }

    //멤버로 아이디 찾기
    public Long getOne(Member member){
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {//Optional method
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //아이디로 멤버 찾기
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
