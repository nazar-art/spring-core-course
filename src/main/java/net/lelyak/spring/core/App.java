package net.lelyak.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.lelyak.spring.core.beans.Client;
import net.lelyak.spring.core.beans.Event;
import net.lelyak.spring.core.beans.EventType;
import net.lelyak.spring.core.logger.ConsoleEventLogger;
import net.lelyak.spring.core.logger.EventLogger;

import java.util.Map;


public class App {

    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    private EventLogger defaultLogger = new ConsoleEventLogger();

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        processEvent(event);
        logger.logEvent(event);
    }

    private void processEvent(Event event) {
        String message = event.getMessage().replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
    }

    public static void main(String[] args) {
//        App app = new App(new Client("1", "John Smith"), new ConsoleEventLogger());
//        app.client = new Client("1", "John Smith");
//        app.eventLogger = new ConsoleEventLogger();

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        event.setMessage("Some event for user 1");

        app.logEvent(EventType.INFO, event);
        app.logEvent(EventType.ERROR, event);

        context.close();
    }
}
