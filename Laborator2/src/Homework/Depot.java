/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import java.util.Objects;

public class Depot {
    private String name;

    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}