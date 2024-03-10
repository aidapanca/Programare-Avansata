/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

public class Concert extends Attraction implements Visitable, Payable {
    private String dayOfWeek;
    private int startTimeHour;
    private int endTimeHour;
    private double ticketPrice;

    public Concert(String name, String description, String dayOfWeek, int startTimeHour, int endTimeHour, double ticketPrice) {
        super(name, description);
        this.dayOfWeek = dayOfWeek;
        this.startTimeHour = startTimeHour;
        this.endTimeHour = endTimeHour;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean isOpenOnDayOfWeek(String dayOfWeek) {
        return this.dayOfWeek.equalsIgnoreCase(dayOfWeek);
    }

    @Override
    public boolean isOpenAtHour(int hour) {
        return hour >= startTimeHour && hour < endTimeHour;
    }

    @Override
    public double getEntryFee() {
        return ticketPrice;
    }

    public int getStartTimeHour() {
        return startTimeHour;
    }

    public int getEndTimeHour() {
        return endTimeHour;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }


}
