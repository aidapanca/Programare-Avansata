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

    //Setter pentru vehicles
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    //Getter pentru vehicles
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    //Getter pentru name
    public String getName() {
        return name;
    }

    //Setter pentru name
    public void setName(String name) {
        this.name = name;
    }

    //Override la toString
    @Override
    public String toString() {
        return "Depot{" + "name='" + name + '\'' + ", vehicles=" + Arrays.toString(vehicles) + '}';
    }
}
