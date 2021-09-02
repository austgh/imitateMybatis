package com.ahzx;

import com.ahzx.luban.annotation.LubanScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 模拟mybatis的@MapperScan注解功能
 * @author think
 */
@Configuration
@ComponentScan("com.ahzx")
@LubanScan("com.ahzx.luban.dao")
/*@MapperScan*/
public class AppConfig {

}
