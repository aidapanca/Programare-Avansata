/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trip {
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;

    public Trip(String cityName, String periodOfTime) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void displayVisitableNotPayable() {
        System.out.println("Visitable, Not Payable Attractions:");
        List<Attraction> visitableNotPayableAttractions = attractions.stream()
                .filter(attraction -> attraction instanceof Visitable && !(attraction instanceof Payable))
                .sorted(Comparator.comparing(attraction -> {
                    if (attraction instanceof Visitable) {
                        return ((Visitable) attraction).getOpeningHour("2024-03-10"); 
                    }
                    return null;
                }))
                .collect(Collectors.toList());

        visitableNotPayableAttractions.forEach(attraction -> System.out.println(attraction.getName() + " - Opening Hour: " + ((Visitable) attraction).getOpeningHour("2024-03-10"))); 
    }
}
