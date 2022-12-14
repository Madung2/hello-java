package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //해시맵은 파이선 딕셔너리. 딕셔너리 타입의 스토어 객체를 만든다.
    //키는 id: Long 타입, 밸류는 name:Member
    private static long sequence =0L; //sequence=012같은 키값을 생성해줌

    @Override //부모를 상속할때 맘에 안드는걸 재정의함!!
    public Member save(Member member) {
        //멤버를 save할때 이런 로직을 탄다~~
        member.setId(++sequence); //아이디가 하나씩 올라가게 만듬
        store.put(member.getId(), member); //맵에 저장됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //id가 없을수도 있기 때문에 Optional.ofNullable로 감싸는 것.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //스토어에 있는 모든 밸류를 반환한다.
    }
    public void clearStore() {
        store.clear();
    }
}
