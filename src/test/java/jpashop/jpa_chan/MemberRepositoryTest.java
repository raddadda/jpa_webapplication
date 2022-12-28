package jpashop.jpa_chan;


import jpashop.jpa_chan.domain.Member;
import jpashop.jpa_chan.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    // 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입한다. 즉 생성자,setter,필드
    MemberRepository memberRepository;

    @Test
    @Transactional
    //데이터 처리중 오류가 발생했을 때 모든 작업들을 원생태로 되돌릴 수 있다.
    //throws는 메소드에서 잠재적으로 어떤 exception이 발생하는지 명시하는 키워드이다.
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");
k
        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        //영속성 엔티티에서 식별자,즉 id가 같으 같은 엔티티다.
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member: " + (findMember == member ));

    }
}
