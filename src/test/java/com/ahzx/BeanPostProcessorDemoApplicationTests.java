package com.ahzx;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImitateMybatisApplication.class)
class ImitateMybatisApplicationTests {
/*
    @Autowired
    AbstractApplicationContext applicationcontext;
*/

    @Test
    public void  test() {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userMapper"));
        System.out.println(context.getBean("user"));
    }
}
