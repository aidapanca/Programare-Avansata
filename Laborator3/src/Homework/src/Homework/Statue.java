/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable, Payable {
    private final Map<String, TimeInterval<LocalTime>> visitingSchedule;
    private final double entryFee;

    public Statue(String name, String description, String dayOfWeek, int openingHour, int closingHour, double entryFee) {
        super(name, description);
        this.visitingSchedule = new HashMap<>();
        this.entryFee = entryFee;
        addVisitingHours(dayOfWeek, LocalTime.of(openingHour, 0), LocalTime.of(closingHour, 0));
    }

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public boolean isPayable() {
        return entryFee > 0;
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
    public LocalTime getOpeningHour(String date) {
        TimeInterval<LocalTime> interval = visitingSchedule.get(date);
        if (interval != null) {
            return interval.getStartTime();
        }
        return null;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }
}




