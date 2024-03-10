/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create objects of each class
        Statue statue = new Statue("StatueName", "StatueDescription", "Monday", 9, 18);
        Church church = new Church("ChurchName", "ChurchDescription", new HashMap<>(), 5.0);
        Concert concert = new Concert("ConcertName", "ConcertDescription", "Saturday", 20, 23, 25.0);

        // Print information about each attraction
        System.out.println("Information about attractions:");
        System.out.println("----------------------------");
        System.out.println("Statue:");
        System.out.println("Name: " + statue.getName());
        System.out.println("Description: " + statue.getDescription());
        System.out.println("Day of Week: " + statue.getDayOfWeek());
        System.out.println("Opening Hour: " + statue.getOpeningHour());
        System.out.println("Closing Hour: " + statue.getClosingHour());
        System.out.println();

        System.out.println("Church:");
        System.out.println("Name: " + church.getName());
        System.out.println("Description: " + church.getDescription());
        System.out.println("Opening Hours: " + church.getOpeningHours());
        System.out.println("Entry Fee: " + church.getEntryFee());
        System.out.println();

        System.out.println("Concert:");
        System.out.println("Name: " + concert.getName());
        System.out.println("Description: " + concert.getDescription());
        System.out.println("Day of Week: " + concert.getDayOfWeek());
        System.out.println("Start Time: " + concert.getStartTimeHour());
        System.out.println("End Time: " + concert.getEndTimeHour());
        System.out.println("Ticket Price: " + concert.getTicketPrice());
    }
}
