/**
 @author Pâncă Aida-Gabriela, A5
 **/

package Compulsory;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Depot d1 = new Depot("Depot 1");
        Vehicle v1 = new Vehicle("Vehicle 1");
        Vehicle v2 = new Vehicle("Vehicle 2");
        d1.setVehicles(v1, v2);
        System.out.println(d1);

        Depot d2 = new Depot("Depot 2");
        Vehicle v3 = new Vehicle("Vehicle 3");
        d2.setVehicles(v3);
        System.out.println(d2);

        Client c1 = new Client();
        c1.setName("Client 1");
        c1.setMinTime(LocalTime.of(8, 0));
        c1.setMaxTime(LocalTime.of(12, 30));
        System.out.println(c1.getName());

        Client c2 = new Client("Client 2");
        System.out.println(c2);

        Client c3 = new Client("Client 3", LocalTime.NOON, LocalTime.MIDNIGHT, ClientType.REGULAR);
        System.out.println(c3);
    }
}