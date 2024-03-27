/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private String directory; //directorul principal in care sunt stocate documentele
    private Map<Person, List<Document>> documents = new HashMap<>(); //mapare intre persoane si listele de documente asociate lor

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments(); //la inițializare, incarcam documentele din director
    }


    //ia numele sub-directorului si extrage Id ul si numele pentru a crea obiectul Person
    private Person employeeDir(String directoryName) {
        String[] parts = directoryName.split("--"); //separam numele si ID-ul angajatului folosind "--" ca separator
        try {
            if (parts.length == 2) {
                return new Person(Integer.parseInt(parts[0]), parts[1]);
            } else {
                return new Person(-1, "unknownEmployee"); //in caz de format neasteptat, cream un angajat cu ID -1 si nume necunoscut
            }
        } catch (NumberFormatException e) {
            //cazul in care partea a doua nu poate fi parsata ca numar intreg
            return new Person(-1, "unknownEmployee");
        }
    }

    // ia numele directorului si extrage numele si formatul pentru a crea obiectul Document
    private Document documentDir(String fileName) {
        String[] parts = fileName.split("\\."); //separam numele si formatul documentului folosind "." ca separator
        if (parts.length == 2) {
            return new Document(parts[0], parts[1]);
        } else {
            return new Document("unknownDocument", "unknownFormat");
        }
    }

    //trece prin structura directirului si asociaza fiecarei persoane(key) documentul ei(value)
    private void loadDocuments() {
        try {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(Paths.get(directory))) {
                        Person person = employeeDir(dir.getFileName().toString());  //extrage infotmatiile angajatilor
                        List<Document> personDocuments = new ArrayList<>();   //aici se stocheaza documentele asociate angajatilor
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { //ne folosim de DirectoryStream pt a putea itera prin directorul curent
                            for (Path file : stream) {
                                personDocuments.add(documentDir(file.getFileName().toString()));
                            }
                        } catch (IOException e) {
                            System.err.println("Error parsing documents: " + e.getMessage());
                        }
                        documents.put(person, personDocuments); //se fac perechile angajat - documente
                    }
                    return FileVisitResult.CONTINUE; //indica daca directorul ar mai trebui parcurs sau il sarim
                }
            });
        } catch (IOException e) {
            System.err.println("Error loading documents: " + e.getMessage());
        }
    }

    public void printRepositoryContent() {
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            System.out.println("Employee: id: " + entry.getKey().id() + ", name: " + entry.getKey().name());
            System.out.println("Document for employee:" );
            for (Document document : entry.getValue()) {
                System.out.println("  - " + document.name() + "." + document.format());
            }
        }
    }
}

