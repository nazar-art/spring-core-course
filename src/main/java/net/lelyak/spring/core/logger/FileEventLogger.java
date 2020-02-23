package net.lelyak.spring.core.logger;

import net.lelyak.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    protected String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IllegalAccessException {
        this.file = new File(fileName);
        // comment because it fails now
        /*if (!file.canWrite()) {
            throw new IllegalAccessException("You do not have access write to file!");
        }*/
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.getMessage(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
