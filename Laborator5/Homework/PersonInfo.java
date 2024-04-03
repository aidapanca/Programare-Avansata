/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import Homework.model.Person;
import java.util.List;

public class PersonInfo {
    private final Person person;
    private List<DocumentInfo> documents;

    public PersonInfo(Person person, List<DocumentInfo> documents) {
        this.person = person;
        this.documents = documents;
    }

    public int getId() {
        return person.id();
    }

    public String getName() {
        return person.name();
    }

    public List<DocumentInfo> getDocuments() {
        return documents;
    }
}
