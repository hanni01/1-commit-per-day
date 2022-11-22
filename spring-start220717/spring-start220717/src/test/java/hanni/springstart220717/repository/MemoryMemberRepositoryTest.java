package hanni.springstart220717.repository;

import hanni.springstart220717.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryMemberRepositoryTest {
    //테스트는 서로 의존성 없이 각각 실행되므로 순서가 없다.
    //즉 데이터가 겹칠 수 있기 때문에 끝날 때마다 초기화해주는 행위가 필요
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //테스트가 실행되고 끝날 때마다 데이터 클린업
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //반환 타입이 Optional이었으므로 Optional에서 값을 꺼낼 때는 get()
        assertEquals(member, result);
        assertThat(member).isEqualTo(result);
        /*Assertion은 블리언 식을 포함.
        * 개발자가 자신이 개발한 프로그램에서 가정하고 있는 사실이
        * 올바른 지 검사할 수 있도록 하기 위해 추가된 새 기능*/
        //만약 참이 아니라면 초록색 마크가 아닌 오류가 뜸

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setId(01l);
        repository.save(member1);

        Member member2 = new Member();
        member2.setId(233l);
        repository.save(member2);

        Member result = repository.findById(member1.getId()).get();

        assertThat(result).isEqualTo(member1);
    }

}
