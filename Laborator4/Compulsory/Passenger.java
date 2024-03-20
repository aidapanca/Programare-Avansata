package Compulsory;

public class Passenger extends Person implements Comparable<Passenger> {

    Passenger (String name, int age, String destination){
        super(name, age, destination);
    }
    public String getTypeOfPerson(){
        return "Passenger";
    }

    @Override
    public int compareTo(Passenger oPerson){
        return this.getName().compareTo(oPerson.getName());
    }
    @Override
    public String toString() {
        return "Passenger's Name: " + getName() + ", " + "Age: " + getAge() + ", " + "Destination: " + getDestination() + "\n";
    }
}