/**
 @author Pâncă Aida-Gabriela, A5
 **/

package Compulsory;
public class Vehicle {
    private String name;
    private Depot depot;

    //Constructor
    public Vehicle(String name) {
        this.name = name;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for depot
    public Depot getDepot() {
        return depot;
    }

    //Setter for depot
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    //Override at toString
    @Override
    public String toString() {
        return "Vehicle{" + "name='" + name + '\'' + '}';
    }

    //Override at equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}

