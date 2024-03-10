/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

public class Statue extends Attraction implements Visitable {
    private String dayOfWeek;
    private int openingHour;
    private int closingHour;

    public Statue(String name, String description, String dayOfWeek, int openingHour, int closingHour) {
        super(name, description);
        this.dayOfWeek = dayOfWeek;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    @Override
    public boolean isOpenOnDayOfWeek(String dayOfWeek) {
        return this.dayOfWeek.equalsIgnoreCase(dayOfWeek);
    }

    @Override
    public boolean isOpenAtHour(int hour) {
        return hour >= openingHour && hour < closingHour;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

}
