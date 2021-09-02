package com.ahzx.luban;

import com.ahzx.luban.entity.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 *
 * @author think
 * BeanFactoryPostProcessor Bean工厂后置处理器
 */
@Component
public class LubanBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
        bd.setBeanClass(A.class);//偷天换日
        bd.getConstructorArgumentValues().addIndexedArgumentValue(0,"gh");
        bd.getConstructorArgumentValues().addIndexedArgumentValue(1,90);

    }
}
