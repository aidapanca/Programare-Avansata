/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import java.util.*;

public class Problem {
    private List<Depot> depots;
    private Map<Depot, List<Vehicle>> vehiclesMap;
    private List<Client> clients;

    public Problem() {
        this.depots = new ArrayList<>();
        this.vehiclesMap = new HashMap<>();
        this.clients = new ArrayList<>();
    }

    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
            vehiclesMap.put(depot, new ArrayList<>());
        }
    }

    public void addVehicle(Depot depot, Vehicle vehicle) {
        if (depots.contains(depot)) {
            List<Vehicle> vehicles = vehiclesMap.get(depot);
            if (!vehicles.contains(vehicle)) {
                vehicles.add(vehicle);
            }
        }
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (List<Vehicle> depotVehicles : vehiclesMap.values()) {
            allVehicles.addAll(depotVehicles);
        }
        return allVehicles.toArray(new Vehicle[0]);
    }

    public void allocateClientsGreedy() {
        // Sort clients by visiting time interval or any other criterion if needed
        Collections.sort(clients, Comparator.comparing(Client::getName));

        // Iterate through clients and assign them to vehicles greedily
        for (Client client : clients) {
            boolean clientAssigned = false;
            for (Map.Entry<Depot, List<Vehicle>> entry : vehiclesMap.entrySet()) {
                Depot depot = entry.getKey();
                List<Vehicle> depotVehicles = entry.getValue();
                for (Vehicle vehicle : depotVehicles) {
                    // Check if vehicle can serve the client based on its type
                    if (vehicle instanceof Truck) {
                        // Check if truck capacity is enough for the client
                        Truck truck = (Truck) vehicle;
                        if (client.getType() == ClientType.REGULAR && truck.getCapacity() >= 1) {
                            // Assign client to truck
                            System.out.println("Client " + client.getName() + " assigned to truck " + truck.getName());
                            clientAssigned = true;
                            truck.setCapacity(truck.getCapacity() - 1); // Decrease truck capacity
                            break;
                        }
                    } else if (vehicle instanceof Drone) {
                        // Check if drone flight duration is enough for the client
                        Drone drone = (Drone) vehicle;
                        if (client.getType() == ClientType.PREMIUM && drone.getMaxFlightDuration() >= 1) {
                            // Assign client to drone
                            System.out.println("Client " + client.getName() + " assigned to drone " + drone.getName());
                            clientAssigned = true;
                            drone.setMaxFlightDuration(drone.getMaxFlightDuration() - 1); // Decrease drone flight duration
                            break;
                        }
                    }
                }
                if (clientAssigned) {
                    break;
                }
            }
            if (!clientAssigned) {
                System.out.println("Client " + client.getName() + " could not be assigned to any vehicle.");
            }
        }
    }

}
