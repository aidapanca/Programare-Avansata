/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public interface Visitable {
    boolean isVisitable();
    default LocalTime getOpeningHour(String date) {
        Map<String, TimeInterval> visitingSchedule = getVisitingSchedule();
        if (visitingSchedule.containsKey(date)) {
            return visitingSchedule.get(date).getStartTime();
        }
        return null;
    }
    void addVisitingHours(String date, LocalTime startTime, LocalTime endTime);
    Map<String, TimeInterval> getVisitingSchedule();
}
