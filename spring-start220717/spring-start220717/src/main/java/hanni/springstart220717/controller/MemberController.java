package hanni.springstart220717.controller;

import hanni.springstart220717.domain.Member;
import hanni.springstart220717.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    @ResponseBody
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        return "Name: "+ member.getName()+", ID: "+ memberService.create(member);
    }

    @GetMapping("/members")
    @ResponseBody
    public List list(Model model){
        return memberService.findMembers();
    }

    @GetMapping("/members/{id}")
    @ResponseBody
    public Optional<Member> findOne(@RequestParam Long id){
        return memberService.findOne(id);
    }
}
