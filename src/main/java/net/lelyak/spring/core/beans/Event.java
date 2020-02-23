package net.lelyak.spring.core.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String message;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        id = new Random().nextInt(1000);
        this.date = date;
        this.df = df;
    }

    public static boolean isDay() {
        boolean result = false;

        LocalTime rightNow = LocalTime.now();
        LocalTime dayStart = LocalTime.of(8, 0);
        LocalTime dayEnd = LocalTime.of(17, 0);

        if (rightNow.isAfter(dayStart) && rightNow.isBefore(dayEnd)) {
            result = true;
        }
        return result;
        /* #{ T(Event).isDay() ? filterEventLogger
                               : consoleEventLogger }

           #{ client.greeting ?: 'Hello' }
                               */
    }

    public static void main(String[] args) {
        System.out.println(isDay());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
