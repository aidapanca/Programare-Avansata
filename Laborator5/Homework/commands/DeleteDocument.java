/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.commands;

import Homework.model.Person;
import Homework.Repository;

public class DeleteDocument implements Command {
    private final Repository repo;

    public DeleteDocument(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: deleteDocument <ID Persoana> <Nume Document>");
            return;
        }

        int personId = Integer.parseInt(args[0]);
        String docName = args[1];

        Person person = repo.findPersonById(personId);
        if (person == null) {
            System.out.println("The person with the ID " + personId + " was not found.");
            return;
        }

        boolean success = repo.deleteDocument(person, docName);
        if (success) {
            System.out.println("The document was successfully deleted.");
        } else {
            System.out.println("The document could not be found.");
        }
    }
}
