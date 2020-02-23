package net.lelyak.spring.core.logger;

import net.lelyak.spring.core.beans.Event;

public interface EventLogger {
    void logEvent(Event event);

//    void init() throws Exception;
}
