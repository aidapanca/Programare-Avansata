/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

public class Main {
    public static void main(String[] args) {
        // Create depots
        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");

        // Create vehicles
        Truck truck1 = new Truck("Truck 1", 100); // Truck with capacity 100
        Truck truck2 = new Truck("Truck 2", 150); // Truck with capacity 150
        Drone drone1 = new Drone("Drone 1", 60);  // Drone with max flight duration 60
        Drone drone2 = new Drone("Drone 2", 90);  // Drone with max flight duration 90

        // Create clients
        Client client1 = new Client("Client 1", ClientType.REGULAR);
        Client client2 = new Client("Client 2", ClientType.PREMIUM);
        Client client3 = new Client("Client 3", ClientType.REGULAR);

        // Create problem instance
        Problem problem = new Problem();

        // Add depots and vehicles
        problem.addDepot(depot1);
        problem.addVehicle(depot1, truck1);
        problem.addVehicle(depot1, drone1);
        problem.addDepot(depot2);
        problem.addVehicle(depot2, truck2);
        problem.addVehicle(depot2, drone2);

        // Add clients
        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);

        // Allocate clients to vehicles using greedy algorithm
        problem.allocateClientsGreedy();
    }
}
