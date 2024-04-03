/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import Homework.model.Document;

public class DocumentInfo {
    private final Document document;

    public DocumentInfo(Document document) {
        this.document = document;
    }

    public String getName() {
        return document.name();
    }

    public String getFormat() {
        return document.format();
    }
}

