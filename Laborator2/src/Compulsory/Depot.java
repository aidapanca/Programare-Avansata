/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.Arrays;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    //Constructor
    public Depot(String name) {
        this.name = name;
    }

    //Setter for vehicles
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    //Getter for vehicles
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Override at toString
    @Override
    public String toString() {
        return "Depot{" + "name='" + name + '\'' + ", vehicles=" + Arrays.toString(vehicles) + '}';
    }
}
