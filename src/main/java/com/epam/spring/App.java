package com.epam.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event) {
        String message = event.getMessage().replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
//        App app = new App(new Client("1", "John Smith"), new ConsoleEventLogger());
//        app.client = new Client("1", "John Smith");
//        app.eventLogger = new ConsoleEventLogger();

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        event.setMessage("Some event for user 1");
        app.logEvent(event);

        context.close();
    }
}
