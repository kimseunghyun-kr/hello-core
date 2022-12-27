package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.AppConfig;

public class BeanDefinitionTest {
    
    //ApplicationContext does not have the gerBeanDefinition present
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // this uses factory methods to load. root bean == null for that reason
    

    // GenericXmlApplicationContext ac2 = new GenericXmlApplicationContext("appConfig.xml");
    // xml have factoryBeanname field etc in beandefinition == null. and the metadata for the classes are all revealed.
//     as xml method is directly loading the beans in the AC;
    @Test
    @DisplayName("find bean config metadata")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName =" + beanDefinitionName + "  beanDefintion = " + beanDefinition);
            }
        }
    }
}
