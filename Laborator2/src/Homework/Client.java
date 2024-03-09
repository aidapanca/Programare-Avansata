/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import java.util.Objects;

public class Client {
    private String name;
    private ClientType type;

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ClientType getType() {
        return type;
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}