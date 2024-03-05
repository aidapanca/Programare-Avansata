/**
 @author Pâncă Aida-Gabriela, A5
 **/

public class Main {
    public static void main(String[] args) {
        if (args.length!=3) {
            System.out.println("Usage: java Main a b k");
            return;
        }
        int a,b,k;
        try {
            a=Integer.parseInt(args[0]);
            b=Integer.parseInt(args[1]);
            k=Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments. Please provide integers for a, b, and k.");
            return;
        }
        if (a<0 || b<0 || k<0) {
            System.out.println("Arguments must be non-negative integers.");
            return;
        }

        StringBuilder result = new StringBuilder();
        long startTime = System.nanoTime();
        for (int i=a; i<=b; i++) {
            if (isKReductible(i, k)) {
                result.append(i).append(" ");
            }
        }
        long endTime=System.nanoTime();
        long duration=(endTime - startTime) / 1000000;

        System.out.println("K-reductible numbers in the interval [" + a + ", " + b + "] for k = " + k + ":");
        System.out.println(result.toString().trim());

        System.out.println("Running time: " + duration + " milliseconds");
    }

    private static boolean isKReductible(int num, int k) {
        while (num >= 10) {
            int sum=0;
            int temp=num;
            while (temp > 0) {
                int digit=temp%10;
                sum+=digit*digit;
                temp/=10;
            }
            num=sum;
        }
        return num==k;
    }
}
