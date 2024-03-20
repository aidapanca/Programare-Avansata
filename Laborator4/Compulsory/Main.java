/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String args[])
    {
        System.out.println("Carpooling: ");

        /** Create a random group of persons. Use streams in order to filter the drivers and the passengers.
         *  @allDrivers si @allPassengers vor fi alesi random de a 1 la 10, vor avea o varsta cuprinsa intre 18 si 70 de ani si vor avea ca varianta 5 destinatii.*/

        List<Person> groupOfPersons = IntStream.rangeClosed(1, 10).mapToObj(i->{
            if(i%2 == 0){
                return new Driver("Driver"+ i, (int)(Math.random() * 53) + 18, "Destination"+ (i % 5 ));
            }else {
                return new Passenger("Passenger"+ i, (int)(Math.random()* 53) + 18, "Destination"+ (i % 5 ));
            }
        }).toList();

        /** Put all the drivers in a LinkedList and print them sorted by their age.*/
        LinkedList<Driver> allDrivers = groupOfPersons.stream().filter(person ->person instanceof Driver).map(person -> (Driver) person).sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toCollection(LinkedList::new));

        /** Put all the passengers in a TreeSet and print them sorted by their name.*/
        Set<Passenger> allPassengers = groupOfPersons.stream().filter(person -> person instanceof Passenger).map(person -> (Passenger) person).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("---All drivers:");
        System.out.println(allDrivers.toString());
        System.out.println("***All passengers:");
        System.out.println(allPassengers.toString());
    }
}