/**
 @author Pâncă Aida-Gabriela, A5
 **/

package Compulsory;

import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;

    // Constructors
    public Client() {
    }

    public Client(String name) {
        this(name, null, null, ClientType.REGULAR);
    }

    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for minTime
    public LocalTime getMinTime() {
        return minTime;
    }

    //Setter for minTime
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    //Getter for maxTime
    public LocalTime getMaxTime() {
        return maxTime;
    }

    //Setter for maxTime
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    //Getter for type
    public ClientType getType() {
        return type;
    }

    //Setter for type
    public void setType(ClientType type) {
        this.type = type;
    }

    //Override at toString
    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", minTime=" + minTime + ", maxTime=" + maxTime + ", type=" + type + '}';
    }
}

