package hello.core.member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

class MemberServiceTest {

    private AppConfig appConfig;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }
    
    
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