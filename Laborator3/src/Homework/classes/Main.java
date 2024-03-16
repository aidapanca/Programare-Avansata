/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.classes;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create attractions
        Church church1 = new Church("St. Mary's Church", "Beautiful historic church", 5.0);
        church1.addVisitingHours("2024-03-10", LocalTime.of(9, 0), LocalTime.of(17, 0));
        church1.addVisitingHours("2024-03-11", LocalTime.of(10, 0), LocalTime.of(16, 0));

        Statue statue1 = new Statue("David", "Famous sculpture", "Monday", 9, 18, 0.0); // Adăugat prețul statuii


        Concert concert1 = new Concert("Pop Concert", "Live music event", "Friday", 20, 23, 25.0);

        // Create travel plan
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(church1, "2024-03-10");
        travelPlan.addVisit(statue1, "2024-03-11");
        travelPlan.addVisit(concert1, "2024-03-12");

        // Display travel plan
        travelPlan.printPlan();
    }
}
