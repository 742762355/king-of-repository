package com.lixin.core.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class ConstructTestPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition boss = (AbstractBeanDefinition) beanFactory.getBeanDefinition("boss");
        System.out.println("autowireMode:" + boss.getAutowireMode());
//        boss.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        System.out.println("autowireMode:" + boss.getAutowireMode());
    }
}
