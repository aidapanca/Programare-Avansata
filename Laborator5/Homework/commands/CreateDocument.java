/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.commands;

import Homework.model.Document;
import Homework.model.Person;
import Homework.Repository;

public class CreateDocument implements Command {
    private final Repository repo;

    public CreateDocument(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: addDocument <ID Persoana> <Nume Document> <Format>");
            return;
        }

        int personId = Integer.parseInt(args[0]);
        String docName = args[1];
        String format = args[2];

        Person person = repo.findPersonById(personId);
        if (person == null) {
            System.out.println("The person with the ID " + personId + " was not found.");
            return;
        }

        Document document = new Document(docName, format);
        repo.addDocument(person, document);
        System.out.println("The document has been successfully added.");
    }
}
