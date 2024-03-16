/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.Map;

public abstract class Attraction implements Visitable, Payable {
    protected String name;
    protected String description;

    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public abstract boolean isVisitable();

    @Override
    public abstract boolean isPayable();

    @Override
    public abstract LocalTime getOpeningHour(String date);
}

