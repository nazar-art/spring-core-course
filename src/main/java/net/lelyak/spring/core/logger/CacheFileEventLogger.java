package net.lelyak.spring.core.logger;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import net.lelyak.spring.core.beans.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    @SneakyThrows
    private void writeEventsFromCache() {
        if (cache.size() > 0) {
            for (Event event : cache) {
                FileUtils.writeStringToFile(new File(fileName), event.getMessage());
            }
        }
        System.out.println("Writing to file... ");
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    public List<Event> getCache() {
        return cache;
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
