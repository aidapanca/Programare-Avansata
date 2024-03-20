package Compulsory;

public class Driver extends Person{
    Driver(String name, int age, String destination)
    {
        super(name, age, destination);
    }

    public String getTypeOfPerson()
    {
        return "Driver";
    }

    @Override
    public String toString() {
        return "Driver's Name: " + getName() + ", " + "Age: " + getAge() + ", " + "Destination: " + getDestination()  + "\n";
    }
}