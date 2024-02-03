package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary // 우선순위, @Autowired 시 여러 빈이 매칭되면 @Primary 어노테이션을 가진 빈이 우선권을 가진다.
//@Qualifier("mainDiscountPolicy") // Qualifier 어노테이션을 사용하면, 추가 구분자를 붙여 @Autowired 를 매칭시켜준다.
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
