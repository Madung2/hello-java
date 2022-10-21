package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =0L; //sequence=012같은 키값을 생성해줌

    @Override //부모를 상속할때 맘에 안드는걸 재정의함!!
    public Member save(Member member) {
        member.setId(++sequence); //아이디가 하나씩 올라가게 만듬
        store.put(member.getId(), member); //맵에 저장됨
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //id가 없을수도 있기 때문에 Optional.ofNullable로 감싸는 것.
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
