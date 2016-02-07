package ua.epam.spring.core.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Monitor implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Application event goes here .....");
    }
}
