package Compulsory;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testRepo();
    }

    private void testRepo() {
        var repo = new Repository("C:\\Users\\aidap\\Desktop\\EmployeesDoc");
        repo.printRepositoryContent();
    }
}
