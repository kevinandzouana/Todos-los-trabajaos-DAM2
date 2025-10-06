package example.newspapercrud.ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import example.newspapercrud.domain.model.CredentialDTO;

import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        try {
            SeContainerInitializer initializer = SeContainerInitializer.newInstance();
            SeContainer container = initializer.initialize();
            CredentialUi credentialUi = container.select(CredentialUi.class).get();
            ArticleUi articleUi = container.select(ArticleUi.class).get();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Newspaper CRUD Application");
            System.out.println("Please log in to continue.");

            boolean loggedIn = false;
            while (!loggedIn) {
                System.out.print("Username: ");
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) continue;

                System.out.print("Password: ");
                String password = scanner.nextLine().trim();
                if (password.isEmpty()) continue;


                loggedIn = credentialUi.checkLogin(new CredentialDTO(username, password));

                if (!loggedIn) {
                    System.out.println("Invalid credentials, please try again.");
                } else {
                    System.out.println("Login successful! Welcome " + username + "!");
                }
            }
            int choice = 0;

            while (choice != 13) {
                System.out.println("1. Get all Articles");
                System.out.println("2. Add Article");
                System.out.println("3. Update Article");
                System.out.println("4. Delete Article");
                System.out.println("5. Get all Newspapers");
                System.out.println("6. Get all Readers");
                System.out.println("7. Get Readers of an Article");
                System.out.println("8. Get Reader by id");
                System.out.println("9. Add rating to an Article");
                System.out.println("10. Modify rating of an Article");
                System.out.println("11. Delete rating of an Article");
                System.out.println("12. Get all Types");
                System.out.println("13. Exit");
                System.out.print("Enter your choice: ");

                // Validar entrada numérica
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                try {
                    choice = Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid choice, please try again.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        //Read all articles
                        System.out.println("Get all Articles option has been selected");
                        System.out.println(articleUi.getArticles());
                        break;
                    case 2:
                        //articleUi.addArticle();
                        break;
                    case 3:
                       //articleUi.updateArticle();
                        break;
                    case 4:
                        System.out.println("Press Enter to delete...");
                        String answer = scanner.nextLine().trim();
                        articleUi.deleteArticle(scanner);
                        break;
                    case 5:
                        //newspaperUi.getAll();
                        break;
                    case 6:
                        //readerUi.getAll();
                        break;
                    case 7:
                        //readerUi.getReadersByIdArticle();
                        break;
                    case 8:
                        //readerUi.getReader();
                        break;
                    case 9:
                        //readerUi.addReadArticle();
                        break;
                    case 10:
                        //readerUi.updateReadArticle();
                        break;
                    case 11:
                        //readerUi.deleteReadArticle();
                        break;
                    case 12:
                        //typeUi.getAll();
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } catch (Exception e) { // Solo errores críticos no manejados
            System.err.println("Fallo grave: " + e.getMessage());
            System.exit(1);
        }
    }

}