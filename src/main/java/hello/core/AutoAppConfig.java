package hello.core;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}


//Overriding bean definition for bean 'memoryMemberRepository' with a different
//definition: replacing

//이 경우 수동 빈 등록이 우선권을 가진다.
//(수동 빈이 자동 빈을 오버라이딩 해버린다.)

//그래서 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을
//바꾸었다.
//수동 빈 등록, 자동 빈 등록 오류시 스프링 부트 에러
//Consider renaming one of the beans or enabling overriding by setting
//spring.main.allow-bean-definition-overriding=true
//스프링 부트인 CoreApplication 을 실행해보면 오류를 볼 수 있다