package hanni.springstart220717.repository;

import hanni.springstart220717.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //보통 return store.get(id)로 원하는 아이디를 가져올 수 있으나
        //데이터가 없는 경우 null이 반환될 수 있으므로 Optional.ofNullable로 감싸주면 문제가 없다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
                //->Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty
    }

    @Override
    public List<Member> findAll() {//반환은 실무에서는 list자주 씀. 루프도 편하기 때문.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
