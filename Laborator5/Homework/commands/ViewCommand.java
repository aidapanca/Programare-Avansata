/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.commands;

import Homework.Repository;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    private Repository repo;

    public ViewCommand(Repository repo) {
        this.repo = repo;
    }
    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: view <filePath>");
            return;
        }
        try {
            File file = new File(args[0]);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File does not exist: " + args[0]);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while opening the file: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("Open operation is not supported on this platform: " + e.getMessage());
        }
    }
}
