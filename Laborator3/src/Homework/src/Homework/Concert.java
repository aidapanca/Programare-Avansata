/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private final String dayOfWeek;
    private final double ticketPrice;
    private final Map<String, TimeInterval<LocalTime>> visitingSchedule;

    public Concert(String name, String description, String dayOfWeek, int startTimeHour, int endTimeHour, double ticketPrice) {
        super(name, description);
        this.dayOfWeek = dayOfWeek;
        this.ticketPrice = ticketPrice;
        this.visitingSchedule = new HashMap<>();
        addVisitingHours(dayOfWeek, LocalTime.of(startTimeHour, 0), LocalTime.of(endTimeHour, 0));
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
        visitingSchedule.put(date, new TimeInterval<>(startTime, endTime));
    }

    @Override
    public Map<String, TimeInterval<LocalTime>> getVisitingSchedule() {
        return visitingSchedule;
    }

    @Override
    public double getEntryFee() {
        return ticketPrice;
    }

    @Override
    public LocalTime getOpeningHour(String date) {
        TimeInterval<LocalTime> interval = visitingSchedule.get(date);
        if (interval != null) {
            return interval.getStartTime();
        }
        return null;
    }
}

