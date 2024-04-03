/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.awt.Desktop;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import Homework.Repository;

public class ReportCommand implements Command {
    private final Configuration cfg;
    private final Repository repo;

    public ReportCommand(Repository repo) {
        this.repo = repo; // Inițializează repository
        cfg = new Configuration(new Version("2.3.31"));
        cfg.setClassForTemplateLoading(ReportCommand.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
    }

    @Override
    public void execute(String[] args) {
        Map<String, Object> templateData = new HashMap<>();


        templateData.put("people", repo.getPeopleDocumentsInfo());

        try {
            Template template = cfg.getTemplate("reportTemplate.flt");
            Path reportPath = Files.createTempFile("report", ".html");
            try (Writer fileWriter = new BufferedWriter(new FileWriter(reportPath.toFile()))) {
                template.process(templateData, fileWriter);
            }

            Desktop.getDesktop().open(reportPath.toFile());
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}

