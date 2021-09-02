package com.ahzx.luban.annotation;

import com.ahzx.luban.register.BeanRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(BeanRegister.class)
public @interface LubanScan {
    String value() default "";
}
