package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

//    @Test
//    public void findByName() {
//        Member user1 = new Member();
//        user1.setName("유저1");
//        repository.save(user1);
//
//        Member user2 = new Member();
//        user1.setName("유저2");
//        repository.save(user2);
//
//        Member result = repository.findByName("유저1").get();
//        assertThat(result).isEqualTo(user1);
//    }

    @Test
    public void findAll() {
        Member user1 = new Member();
        user1.setName("유저1");
        repository.save(user1);

        Member user2 = new Member();
        user1.setName("유저2");
        repository.save(user2);

        List<Member> result = repository.findAll();
    }
}
