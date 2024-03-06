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

    // Constructori
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

    //Getter pentru name
    public String getName() {
        return name;
    }

    //Setter pentru name
    public void setName(String name) {
        this.name = name;
    }

    //Getter pentru minTime
    public LocalTime getMinTime() {
        return minTime;
    }

    //Setter pentru minTime
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    //Getter pentru maxTime
    public LocalTime getMaxTime() {
        return maxTime;
    }

    //Setter pentru maxTime
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    //Getter pentru type
    public ClientType getType() {
        return type;
    }

    //Setter pentru type
    public void setType(ClientType type) {
        this.type = type;
    }

    //Override la toString
    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", minTime=" + minTime + ", maxTime=" + maxTime + ", type=" + type + '}';
    }
}

