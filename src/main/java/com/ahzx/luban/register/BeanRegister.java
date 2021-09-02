package com.ahzx.luban.register;

import com.ahzx.luban.annotation.LubanScan;
import com.ahzx.luban.LubanFactoryBean;
import com.ahzx.luban.dao.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
       //扫描
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(LubanScan.class.getName());
        Object o = annotationAttributes.get("value");
        System.out.println(o);
        //获取目录下的所有的mapper 加入到list中
        String filePath = o.toString().replace(".", "/");
        System.out.println("---------:"+filePath);
        File file = new File(filePath);
        File[] tempFile = file.listFiles();
        ArrayList<Object> fileList = new ArrayList<>();
//        assert tempFile != null;
//        for (File value : tempFile) {
//            if(value.isFile()){
////                addFileToList(fileList, value,filePath);
//            }
//        }
        List<Class> mappers=new ArrayList<>();
        mappers.add(UserMapper.class);
        for (Class mapper:mappers) {
            BeanDefinitionBuilder builder=BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition bd=builder.getBeanDefinition();
            bd.getConstructorArgumentValues().addGenericArgumentValue(mapper);
            bd.setBeanClass(LubanFactoryBean.class);
//            System.out.println("---------"+mapper.getName());
            registry.registerBeanDefinition("userMapper",bd);
        }
    }
}
