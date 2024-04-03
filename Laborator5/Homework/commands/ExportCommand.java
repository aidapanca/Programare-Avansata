/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import Homework.Repository;
import java.io.File;
import java.io.IOException;

public class ExportCommand implements Command {
    private final Repository repo;

    public ExportCommand(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {

            String fileName = args.length > 0 ? args[0] : "repository.json";
            File file = new File(fileName);

            mapper.writeValue(file, repo.getPeopleDocuments());

            System.out.println("The data has been successfully exported to the file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("\"Error while exporting the data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
