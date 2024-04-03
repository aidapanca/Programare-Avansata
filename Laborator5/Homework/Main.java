/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import Homework.commands.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Main app=new Main();
        app.testRepo();
        app.runShell();
    }
    private void testRepo()
    {
        var repo=new Repository("C:\\Users\\aidap\\Desktop\\EmployeesDoc");
        repo.printRepositoryContent();
    }
    private void runShell()
    {
        Scanner scanner=new Scanner(System.in);
        Repository repo=new Repository("C:\\Users\\aidap\\Desktop\\EmployeesDoc");
        ViewCommand viewCommand = new ViewCommand(repo);
        ReportCommand reportCommand = new ReportCommand(repo);
        CreateDocument createDocument = new CreateDocument(repo);
        DeleteDocument deleteDocument = new DeleteDocument(repo);
        while(true)
        {
            System.out.print("Enter command: ");
            String inputLine=scanner.nextLine();
            if(inputLine.isBlank()) continue;
            String[] parts=inputLine.trim().split("\\s+", 2);
            String command=parts[0];
            String[] commandArgs=parts.length > 1 ? parts[1].split("\\s+") : new String[0];

            switch(command.toLowerCase())
            {
                case "view":
                    viewCommand.execute(commandArgs);
                    break;
                case "report":
                    reportCommand.execute(commandArgs);
                    break;
                case "export":
                    ExportCommand exportCommand = new ExportCommand(repo);
                    exportCommand.execute(commandArgs);
                    break;
                case "testrepo":
                    testRepo();
                    break;
                case "adddocument":
                    createDocument.execute(commandArgs);
                    break;
                case "deletedocument":
                    deleteDocument.execute(commandArgs);
                    break;
                case "exit":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}