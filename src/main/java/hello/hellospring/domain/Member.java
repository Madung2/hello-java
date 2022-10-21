package hello.hellospring.domain;
import javax.persistence.*;


//도메인에는 멤버 클래스를 만든다.


@Entity
public class Member {
    //@id는 pk값이라고 지정해주는 것!
    //db에 넣으면 db가 아이디를 자동으로 생성해주는 것을 아이덴티티 전략이라고 함.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //시스템 아이디

    @Column(name= "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
