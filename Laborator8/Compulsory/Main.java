/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

public class Main {
    public static void main(String[] args) {
        try {
            //crearea unei instante a clasei AuthorDAO
            AuthorDAO authorDAO = new AuthorDAO();

            //adaugarea primului autor
            String authorName1 = "Maria Cioratanu";
            int authorId1 = authorDAO.create(authorName1);
            System.out.println("Author " + authorName1 + " with ID: " + authorId1 + " has been added to the database.");

            //adăugarea celui de-al doilea autor
            String authorName2 = "Miruna Varzar";
            int authorId2 = authorDAO.create(authorName2);
            System.out.println("Author " + authorName2 + " with ID: " + authorId2 + " has been added to the database.");

            //adaugarea celui de-al treilea autor
            String authorName3 = "Malina Zara";
            int authorId3 = authorDAO.create(authorName3);
            System.out.println("Author " + authorName3 + " with ID: " + authorId3 + " has been added to the database.");

            //cautarea unui autor dupa nume si actualizarea acestuia
            Author author = authorDAO.findByName(authorName1);
            if (author != null) {
                authorDAO.update(author.getId(), "Eric Arthur Blair");
                System.out.println("Author " + authorName1 + " has been updated to Marta Cioratanu.");
            }

            //cautarea unui autor dupa ID
            authorId1 = 49; //presupune ca acesta este ID-ul pe care dorim sa il cautam
            Author foundAuthor = authorDAO.findById(authorId1);
            if (foundAuthor != null) {
                System.out.println("Author with ID " + authorId1 + " is " + foundAuthor.getName() + ".");
            }

            //stergerea unui autor dupa ID
            authorDAO.delete(authorId1);
            System.out.println("Author with ID " + authorId1 + " has been deleted.");

            //confirm toate schimbarile in baza de date
            Database.getInstance().getConnection().commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                //in caz de eroare, fac rollback la schimbari
                Database.getInstance().getConnection().rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                //inchid conexiunea la baza de date
                Database.getInstance().getConnection().close();
            } catch (Exception closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}
