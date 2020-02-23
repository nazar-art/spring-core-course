package net.lelyak.spring.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwareBean implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void init() {
        System.out.println("Aware init method ...");
        System.out.println("Application name: " + context.getApplicationName());
        System.out.println("Context name: " + context.getDisplayName());
        System.out.println("Context id: " + context.getId());
    }
}
