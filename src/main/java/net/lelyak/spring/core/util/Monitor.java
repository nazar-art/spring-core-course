package net.lelyak.spring.core.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Monitor implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Application event goes here .....");
    }
}
