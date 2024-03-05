import java.util.ArrayList;

public class WheelGraph {
    private int n;
    private int[][] adjacencyMatrix;

    public WheelGraph(int n) {
        this.n=n;
        this.adjacencyMatrix = new int[n][n];
        generateAdjacencyMatrix();
    }

    //adjacency matrix
    private void generateAdjacencyMatrix() {
        // Hub vertex
        for (int i=0; i<n; i++) {
            adjacencyMatrix[0][i]=1;
            adjacencyMatrix[i][0]=1;
        }

        //spokes
        for (int i = 1; i < n; i++) {
            adjacencyMatrix[i][(i+1)%n]=1;
            adjacencyMatrix[(i+1)%n][i]=1;
        }
    }

    //display the adjacency matrix
    public void displayAdjacencyMatrix() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //find all cycles of the wheel graph
    public ArrayList<ArrayList<Integer>> findAllCycles() {
        ArrayList<ArrayList<Integer>> cycles = new ArrayList<>();
        for (int i=1; i<n; i++) {
            ArrayList<Integer> cycle = new ArrayList<>();
            cycle.add(0); //adding the hub vertex to start the cycle
            cycle.add(i);
            cycle.add(0); //adding the hub vertex to end the cycle
            cycles.add(cycle);
        }
        return cycles;
    }

    //main method to test the code
    public static void main(String[] args) {
        int n=5; //change the value of n as needed
        WheelGraph wheelGraph = new WheelGraph(n);

        //display the adjacency matrix
        System.out.println("Adjacency Matrix:");
        wheelGraph.displayAdjacencyMatrix();

        //find all cycles
        ArrayList<ArrayList<Integer>> cycles = wheelGraph.findAllCycles();
        int expectedNumberOfCycles = n*n-3*n+3;
        int actualNumberOfCycles = cycles.size();

        //verify the number of cycles
        System.out.println("\nExpected number of cycles: " + expectedNumberOfCycles);
        System.out.println("Actual number of cycles: " + actualNumberOfCycles);
        if (actualNumberOfCycles == expectedNumberOfCycles) {
            System.out.println("Verification: PASSED");
        } else {
            System.out.println("Verification: FAILED");
        }
    }
}
