package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        // Member는 스프링 빈이 아니다.
        // 자동 주입할 대상이 없으면 메서드 자체가 호출이 안된다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("setNoBean1 = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("setNoBean2 = " + noBean2);
        }
        @Autowired(required = false)
        public void setNoBean1(Optional<Member> noBean3){
            System.out.println("setNoBean3 = " + noBean3);
        }
    }
}
