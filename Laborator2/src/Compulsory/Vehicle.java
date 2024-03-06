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

    //Getter pentru name
    public String getName() {
        return name;
    }

    //Setter pentru name
    public void setName(String name) {
        this.name = name;
    }

    //Getter pentru depot
    public Depot getDepot() {
        return depot;
    }

    //Setter pentru depot
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    //Override la toString
    @Override
    public String toString() {
        return "Vehicle{" + "name='" + name + '\'' + '}';
    }

    //Override la equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}

