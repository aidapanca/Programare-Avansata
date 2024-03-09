/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import java.util.Objects;

public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by subclasses
    public abstract void move();

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
