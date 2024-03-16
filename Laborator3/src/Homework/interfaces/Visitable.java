/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.interfaces;

import Homework.classes.TimeInterval;

import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    boolean isVisitable();

    default Map<String, TimeInterval<LocalTime>> getVisitingSchedule() {
        return null;
    }

    default LocalTime getOpeningHour(String date) {
        Map<String, TimeInterval<LocalTime>> visitingSchedule = getVisitingSchedule();
        if (visitingSchedule.containsKey(date)) {
            return visitingSchedule.get(date).getStartTime();
        }
        return null;
    }

    void addVisitingHours(String date, LocalTime startTime, LocalTime endTime);
}


