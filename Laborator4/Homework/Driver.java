/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import java.util.*;

class Driver extends Person {
    private List<Destination> destinations;
    private List<Passenger> passengers; //lista de pasageri asociati

    public Driver(String name, List<Destination> destinations) {
        super(name);
        this.destinations = destinations;
        this.passengers = new ArrayList<>(); //inițializam lista de pasageri
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    /*public List<Passenger> getPassengers() {
        return passengers;
    }*/

    //metoda pentru a verifica daca soferul poate lua un anumit pasager
    public boolean canTakePassenger(Passenger passenger) {
        return destinations.contains(passenger.getDestination()) && passengers.size() < 3;
    }

    //metoda pentru a adauga un pasager la lista de pasageri
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}
