/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable {
    private String dayOfWeek;
    private int openingHour;
    private int closingHour;
    private Map<String, TimeInterval> visitingSchedule;

    public Statue(String name, String description, String dayOfWeek, int openingHour, int closingHour) {
        super(name, description);
        this.dayOfWeek = dayOfWeek;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.visitingSchedule = new HashMap<>();
    }

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public void addVisitingHours(String date, LocalTime startTime, LocalTime endTime) {
        visitingSchedule.put(date, new TimeInterval(startTime, endTime));
    }

    @Override
    public Map<String, TimeInterval> getVisitingSchedule() {
        return visitingSchedule;
    }

    @Override
    public LocalTime getOpeningHour(String date) {
        TimeInterval interval = visitingSchedule.get(date);
        if (interval != null) {
            return interval.getStartTime();
        }
        return null;
    }

}
