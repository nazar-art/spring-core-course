package ua.epam.spring.core.logger;

import ua.epam.spring.core.beans.Event;

public interface EventLogger {
    void logEvent(Event event);

//    void init() throws Exception;
}
