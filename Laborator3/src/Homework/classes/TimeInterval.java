/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.classes;

import java.time.LocalTime;

public class TimeInterval<T extends LocalTime> {
    private T startTime;
    private T endTime;

    public TimeInterval(T startTime, T endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public T getStartTime() {
        return startTime;
    }

    public T getEndTime() {
        return endTime;
    }
}

