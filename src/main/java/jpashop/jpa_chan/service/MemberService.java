package jpashop.jpa_chan.service;

import jpashop.jpa_chan.domain.Member;
import jpashop.jpa_chan.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
//@AllArgsConstructor
@RequiredArgsConstructor
//final이 있는 필드만가지고 생성자를 만든다.
public class MemberService {

    //@Autowired
    //스프링이 스프링빈에 등록되어있는 멤버 리포지토리를 인젝션해준다.
    private final MemberRepository memberRepository;
   //
   // public MemberService(MemberRepository memberRepository){
   //      this.memberRepository = memberRepository;
   //   }
//회원 가입
    @Transactional
//읽기가아닌 쓰기에서는 readonly를 쓰면 안된다.
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            //isEmpty() 문자열의 길이가 0인 경우에 True를 리턴
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원 전체 조회
    //조회할때 성능 최적화를 해줄 수 있다.
    @Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
