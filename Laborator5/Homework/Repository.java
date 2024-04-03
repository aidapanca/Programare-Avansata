/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

import Homework.exceptions.BadPathException;
import Homework.model.Document;
import Homework.model.Person;

public class Repository
{

    private String directory;
    private Map<Person, List<Document>> documents=new HashMap<>();
    public Repository(String directory)
    {
        if(!pathExistsAndIsDirectory(directory))
            throw new BadPathException("Given path is not a correct directory: " + directory);
        this.directory=directory;
        loadDocuments();
    }
    public Map<Person, List<Document>> getPeopleDocuments() {
        return documents;
    }
    private boolean pathExistsAndIsDirectory(String path)
    {
        Path tmpPath=Paths.get(path);
        return Files.exists(tmpPath) && Files.isDirectory(tmpPath);
    }
    private Person createPerson(String directoryName)
    {
        String[] twoParts=directoryName.split("--");
        try
        {
            if(twoParts.length==2)
                return new Person(Integer.parseInt(twoParts[0]), twoParts[1]);
            else
                return new Person(-1, "unknown_Person");
        }
        catch(NumberFormatException e)
        {
            return new Person(-1, "unknown_Person");
        }
    }

    private Document createDocument(String fileName)
    {
        String[] parts=fileName.split("\\.");
        if(parts.length==2)
            return new Document(parts[0], parts[1]);
        else
            return new Document("unknown_Document", "unknown_Format");
    }

    private void loadDocuments()
    {
        try
        {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    if(!dir.equals(Paths.get(directory)))
                    {
                        Person person=createPerson(dir.getFileName().toString());
                        List<Document> personDocuments=new ArrayList<>();
                        try(DirectoryStream<Path> stream=Files.newDirectoryStream(dir))
                        {
                            for(Path file : stream)
                                personDocuments.add(createDocument(file.getFileName().toString()));
                        }
                        catch (IOException e)
                        {
                            System.err.println("Error parsing documents: " + e.getMessage());
                        }
                        documents.put(person, personDocuments);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch(IOException e)
        {
            System.err.println("Error loading documents: " + e.getMessage());
        }
    }
    public void printRepositoryContent()
    {
        List<Person> sortedPersons=documents.keySet().stream()
                .sorted(Comparator.comparingInt(Person::id))
                .toList();
        for(Person person : sortedPersons)
        {
            List<Document> personDocuments=documents.get(person);
            System.out.println("NAME: " + person.name() + ", ID: " + person.id());
            System.out.println("Documents:");
            for(Document document : personDocuments)
                System.out.println("  - " + document.name() + "." + document.format());
        }
    }
    public Person findPersonById(int id) {
        for (Person person : documents.keySet()) {
            if (person.id() == id) {
                return person;
            }
        }
        return null;
    }

    public boolean addDocument(Person person, Document newDocument) {
        if (person == null || newDocument == null) {
            return false;
        }

        List<Document> personDocuments = documents.get(person);
        if (personDocuments == null) {
            personDocuments = new ArrayList<>();
            documents.put(person, personDocuments);
        }

        return personDocuments.add(newDocument);
    }
    public boolean deleteDocument(Person person, String docName) {
        List<Document> personDocuments = documents.get(person);
        if (personDocuments != null) {
            Iterator<Document> iterator = personDocuments.iterator();
            while (iterator.hasNext()) {
                Document doc = iterator.next();
                if (doc.name().equals(docName)) {
                    iterator.remove();
                    return true;
                }
            }

        }
        return false;
    }
    public List<PersonInfo> getPeopleDocumentsInfo() {
        List<PersonInfo> personInfoList = new ArrayList<>();
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            List<DocumentInfo> documentInfoList = entry.getValue().stream()
                    .map(DocumentInfo::new)
                    .collect(Collectors.toList());
            personInfoList.add(new PersonInfo(entry.getKey(), documentInfoList));
        }
        return personInfoList;
    }


    public Map<Person, List<Document>> getDocuments()
    {
        return this.documents;
    }
    public void setDocuments(Map<Person, List<Document>> documents)
    {
        this.documents=documents;
    }
    public String getDirectory()
    {
        return directory;
    }
    public void setDirectory(String directory)
    {
        this.directory=directory;
    }
}

