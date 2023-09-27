package com.zguiz.musicplayer.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class IocDemo {
    private String test;
    public void buildIoc(){
        test = "eewwwttss";
       /* ClassPathResource res = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader= new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);*/
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }
}
