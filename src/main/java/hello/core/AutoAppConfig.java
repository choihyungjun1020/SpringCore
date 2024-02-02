package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    /**
     * 수동 빈 등록
     * 빈을 오버라이딩해서 등록한다.
     *
     * 최근 스프링 부트는 수동 빈 등록과 자동 빈 등록이 충돌하게 되는 경우, 오류가 발생하도록 기본 값을 바꾸었다.
     */
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
