package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {

    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    void vip_o() {
        //given
        Member member = new Member(1L, "spring1", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        //given
        Member member = new Member(1L, "spring1", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
