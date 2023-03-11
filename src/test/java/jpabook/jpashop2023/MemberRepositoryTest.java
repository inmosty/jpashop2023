package jpabook.jpashop2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");
        //when
        Long saveId = memberRepository.save(member);
        Member findMember1 = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember1.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember1.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember1).isEqualTo(member);
    }
}