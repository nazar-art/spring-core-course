package ua.epam.spring.core.logger;

import ua.epam.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
