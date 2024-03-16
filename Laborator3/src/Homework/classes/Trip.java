/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.classes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trip {
    private List<Attraction> attractions;

    public Trip(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void displayVisitableNotPayable() {
        System.out.println("Visitable, Not Payable Attractions:");
        List<Attraction> visitableNotPayableAttractions = attractions.stream()
                .filter(attraction -> attraction.isVisitable() && !attraction.isPayable())
                .sorted(Comparator.comparing(attraction -> attraction.getOpeningHour("2024-03-10")))
                .collect(Collectors.toList());

        visitableNotPayableAttractions.forEach(attraction -> System.out.println(attraction.getName() + " - Opening Hour: " + attraction.getOpeningHour("2024-03-10")));
    }
}