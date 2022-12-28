package jpashop.jpa_chan.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jpashop.jpa_chan.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext -> 스프링부트에서 @Autowired로 바꿀 수 있다.
    //Entity를 영구 저장하는 환경
    private final EntityManager em;
    //그러면 위에 final을 쓰고 아래를 지울 수 있다.
  //  public MemberRepository(EntityManager em){
 //       this.em=em;
 //   }

   // @PersistenceUnit
    //manager 팩토리를 직 주입받을 수 있다.
   // private EntityManagerFactory emf;

    //트랜잭션에서 커밋되는 과정에서 DB에 반영이 된다.
    public void save(Member member)
    {
        em.persist(member);
    }
//단건 조회이며, pk를 넣어준다.
    public Member findOne(Long id){
       return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
//특정회원찾기
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
