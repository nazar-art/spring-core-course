package ua.epam.spring.core.util;

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
        System.out.println(context.getApplicationName());
        System.out.println(context.getDisplayName());
        System.out.println(context.getId());
    }
}
