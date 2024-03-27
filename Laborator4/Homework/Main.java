/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;


public class Main {
    public static void main(String[] args) {
        CarpoolingProblem problem = new CarpoolingProblem();
        problem.solveProblem();
        //problem.displayDriversAndPassengers(); //afisez informatii despre soferi si pasageri

        int maxMatches = CarpoolingProblem.solveMaxMatch(problem.getDrivers(), problem.getPassengers());
        System.out.println("Numărul maxim de cuplaje: " + maxMatches);
    }
}
