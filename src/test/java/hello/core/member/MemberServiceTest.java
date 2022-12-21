package hello.core.member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private AppConfig appConfig = new AppConfig();
    private MemberService memberService = appConfig.memberService();
    
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}