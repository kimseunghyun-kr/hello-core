package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

class ApplicationContextExtendsFindTest {
    class ApplicationContextInfoTest {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

        @Test
        @DisplayName("if queried by parent type, if there are more than two children class, there is a duplicate error")
        void findBeanByParentTypeDuplicate() {
           DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
           assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));

        }

        @Test
        @DisplayName("to show how to workaround the duplicate bean issue => call by name ")
        void findBeanByNameWorkAround() {
            DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
            assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
        }
    
        @Test
        @DisplayName(" find beans via subtype not recommended")
        void findBeanBySubType() {
            DiscountPolicy bean = ac.getBean( RateDiscountPolicy.class);
            assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    
        }

        @Test
        @DisplayName(" find All beans via parent type")
        void findAllbeanByParentType() {
            Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType( DiscountPolicy.class);
            assertThat(beansOfType.size()).isEqualTo(2);
    
        }

        @Test
        @DisplayName(" find All beans via Object class -> results in both user / spring stuff")
        void findAllbeanByObjectType() {
            Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
            assertThat(beansOfType.size()).isEqualTo(2);
    
        }

        

        

        @Configuration
        static class SameBeanConfig {
            @Bean
            public DiscountPolicy rateDiscountPolicy() {
                return new RateDiscountPolicy();
            }

            @Bean
            public DiscountPolicy fixDiscountPolicy() {
                return new FixDiscountPolicy();
            }
        }
    }
}