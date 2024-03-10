/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.List;
import java.util.Map;

public class Church extends Attraction implements Visitable, Payable {
    private Map<String, List<Integer>> openingHours;
    private double entryFee;

    public Church(String name, String description, Map<String, List<Integer>> openingHours, double entryFee) {
        super(name, description);
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public boolean isOpenOnDayOfWeek(String dayOfWeek) {
        return openingHours.containsKey(dayOfWeek);
    }

    @Override
    public boolean isOpenAtHour(int hour) {
        for (List<Integer> hours : openingHours.values()) {
            for (int openingHour : hours) {
                if (hour >= openingHour && hour < openingHour + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }

    public Map<String, List<Integer>> getOpeningHours() {
        return openingHours;
    }


}
