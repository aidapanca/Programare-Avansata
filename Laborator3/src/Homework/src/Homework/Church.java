/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction implements Visitable, Payable {
    private final Map<String, TimeInterval<LocalTime>> visitingSchedule;
    private final double entryFee;

    public Church(String name, String description, double entryFee) {
        super(name, description);
        this.visitingSchedule = new HashMap<>();
        this.entryFee = entryFee;
    }

    @Override
    public boolean isVisitable() {
        return !visitingSchedule.isEmpty();
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


