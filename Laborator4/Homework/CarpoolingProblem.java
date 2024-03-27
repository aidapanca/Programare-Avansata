package Homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

class CarpoolingProblem {
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public void solveProblem() {
        generateRandomDriversAndPassengers(1000, 1000);

        //calculam toate destinatiile prin care trec soferii
        List<Destination> allDriverDestinations = computeAllDriverDestinations();

        //un map care asociaza fiecarei destinatii lista de persoane care doresc sa ajunga acolo
        Map<Destination, List<Person>> destinationMap = allDriverDestinations.stream()
                .collect(Collectors.toMap(dest -> dest,
                        dest -> {
                            List<Person> people = new ArrayList<>();
                            //adaugam soferii care trec prin aceasta destinatie
                            drivers.stream()
                                    .filter(driver -> driver.getDestinations().contains(dest))
                                    .forEach(people::add);
                            //adaugam pasagerii care doresc sa ajunga la aceasta destinatie
                            passengers.stream()
                                    .filter(passenger -> passenger.getDestination().equals(dest))
                                    .forEach(people::add);
                            return people;
                        }));

        displayResults(allDriverDestinations, destinationMap);

    }

    //metoda pentru generarea aleatoare a soferilor si pasagerilor
    private void generateRandomDriversAndPassengers(int numDrivers, int numPassengers) {
        Faker faker = new Faker();

        List<Destination> allDestinations = generateDestinations();

        drivers = new ArrayList<>();
        for (int i = 0; i < numDrivers; i++) {
            List<Destination> driverDestinations = generateDriverDestinations(allDestinations);
            if (!driverDestinations.isEmpty()) {
                String driverName = faker.name().fullName();
                drivers.add(new Driver(driverName, driverDestinations));
            }
        }

        passengers = new ArrayList<>();
        for (int i = 0; i < numPassengers; i++) {
            String passengerName = faker.name().fullName();
            Destination passengerDestination = allDestinations.get(faker.random().nextInt(allDestinations.size()));
            passengers.add(new Passenger(passengerName, passengerDestination));
        }
    }

    private List<Destination> generateDriverDestinations(List<Destination> allDestinations) {
        Faker faker = new Faker();
        List<Destination> driverDestinations = new ArrayList<>();
        int numDestinations = faker.random().nextInt(1, 4); //nr random de destinatii (intre 1 si 3)
        for (int i = 0; i < numDestinations; i++) {
            Destination destination = allDestinations.get(faker.random().nextInt(allDestinations.size()));
            if (!driverDestinations.contains(destination)) {
                driverDestinations.add(destination);
            }
        }
        return driverDestinations;
    }

    private List<Destination> generateDestinations() {
        Faker faker = new Faker();
        List<Destination> destinations = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            destinations.add(new Destination(faker.address().city()));
        }
        return destinations;
    }

    //metoda pentru calcularea tuturor destinatiilor prin care trec soferii
    private List<Destination> computeAllDriverDestinations() {
        return drivers.stream()
                .flatMap(driver -> driver.getDestinations().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    //metoda pentru a obtine lista de soferi
    public List<Driver> getDrivers() {
        return drivers;
    }

    //metoda pentru a obtine lista de pasageri
    public List<Passenger> getPassengers() {
        return passengers;
    }

    private void displayResults(List<Destination> destinations, Map<Destination, List<Person>> destinationMap) {
        System.out.println("List of all destinations that the drivers pass through:");
        destinations.forEach(destination -> System.out.println(destination.getAddress()));

        System.out.println("\nMap of destinations and people who want to go there:");
        for (Map.Entry<Destination, List<Person>> entry : destinationMap.entrySet()) {
            System.out.println(entry.getKey().getAddress() + ": " +
                    entry.getValue().stream().map(Person::getName).collect(Collectors.toList()));
        }
        System.out.println();
    }

    /*metoda pentru a afiaa informatii despre soferi si pasageri
    public void displayDriversAndPassengers() {
        System.out.println("Drivers and their destinations:");
        for (Driver driver : drivers) {
            System.out.println(driver.getName() + ": " + driver.getDestinations().stream()
                    .map(Destination::getAddress)
                    .collect(Collectors.toList()));
        }

        System.out.println("\nPassengers and their destinations:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName() + ": " + passenger.getDestination().getAddress());
        }
        System.out.println();
    }*/

    public static int solveMaxMatch(List<Driver> drivers, List<Passenger> passengers) {
        //sortam soferii in ordine descrescatoare a numarului de destinatii
        drivers.sort(Comparator.comparingInt(driver -> -driver.getDestinations().size()));

        int maxMatches = 0;

        //parcurgem lista de soferi
        for (Driver driver : drivers) {
            //parcurgem lista de pasageri
            for (Passenger passenger : passengers) {
                //verificam dacă pasagerul este deja asociat cu alt sofer
                if (!passenger.isAllocated()) {
                    //verificam compatibilitatea intre sofer si pasager
                    if (driver.canTakePassenger(passenger)) {
                        //ssociem pasagerul cu soferul si incrementam numarul de cuplaje
                        driver.addPassenger(passenger);
                        passenger.setAllocated(true);
                        maxMatches++;
                        break; //trecem la următorul sofer
                    }
                }
            }
        }

        return maxMatches;
    }
}