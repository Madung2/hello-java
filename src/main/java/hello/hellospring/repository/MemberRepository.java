package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


//리포지토리는 회원객체를 저장하는 저장소
//기능: save, findByID(id로 회원을 찾는 기능), findByName(이름으로 회원을 찾는 기능)


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
