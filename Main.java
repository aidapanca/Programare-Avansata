/**
 @author Pâncă Aida-Gabriela, A5
 **/

import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        Random random = new Random();
        int n = random.nextInt(1_000_000);
        long result=n*3;
        result+=Integer.parseInt("10101", 2);
        result+=Integer.parseInt("FF", 16);
        result*=6;
            while (result>=10) {
                long aux=result;
                    result=0;
                while (aux != 0) {
                    result+=aux%10;
                    aux/=10;
                }
            }
        System.out.println("Willy-nilly, this semester I will learn "+languages[(int) result]);
    }
}
