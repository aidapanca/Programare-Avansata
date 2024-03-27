/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

class Passenger extends Person {
    private Destination destination;
    private boolean allocated; //variabila pentru a urmari daca pasagerul este alocat unui sofer

    public Passenger(String name, Destination destination) {
        super(name);
        this.destination = destination;
        this.allocated = false; //inițializam pasagerul ca nealocat
    }

    public Destination getDestination() {
        return destination;
    }

    //metoda pentru a verifica daca pasagerul este alocat unui sofer
    public boolean isAllocated() {
        return allocated;
    }

    //metoda pentru a marca pasagerul ca alocat sau nealocat
    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }
}
