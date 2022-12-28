package jpashop.jpa_chan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
public class Member {

    @Id
    //기본키를 지정한다
    @GeneratedValue

    @Column(name = "member_id")

    private Long id;

    private String name;

    @Embedded
    private Address address;
     //컬렉션은 필드에서 바로 초기화하기
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
