/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.util.Map;
import java.util.TreeMap;

public class TravelPlan {
    private TreeMap<String, Attraction> plan;

    public TravelPlan() {
        this.plan = new TreeMap<>();
    }

    public void addVisit(Attraction attraction, String date) {
        plan.put(date, attraction);
    }

    public void printPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<String, Attraction> entry : plan.entrySet()) {
            String date = entry.getKey();
            Attraction attraction = entry.getValue();
            System.out.println("Date: " + date + " - Attraction: " + attraction.getName());
        }
    }
}

