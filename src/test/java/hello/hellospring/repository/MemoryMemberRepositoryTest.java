package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member user1 = new Member();
        user1.setName("유저1");
        repository.save(user1);

        Member user2 = new Member();
        user1.setName("유저2");
        repository.save(user2);

        Member result = repository.findByName("유저1").get();
        assertThat(result).isEqualTo(user1);
    }
}
