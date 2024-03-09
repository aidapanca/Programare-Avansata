/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String name, int maxFlightDuration) {
        super(name);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }

    @Override
    public void move() {
        System.out.println("Drone is flying...");
    }
}