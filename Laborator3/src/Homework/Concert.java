/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private String dayOfWeek;
    private int startTimeHour;
    private int endTimeHour;
    private double ticketPrice;
    private Map<String, TimeInterval> visitingSchedule;

    public Concert(String name, String description, String dayOfWeek, int startTimeHour, int endTimeHour, double ticketPrice) {
        super(name, description);
        this.dayOfWeek = dayOfWeek;
        this.startTimeHour = startTimeHour;
        this.endTimeHour = endTimeHour;
        this.ticketPrice = ticketPrice;
        this.visitingSchedule = new HashMap<>();
    }

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public boolean isPayable() {
        return ticketPrice > 0;
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
    public double getEntryFee() {
        return ticketPrice;
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
