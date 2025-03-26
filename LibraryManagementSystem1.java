import java.util.*;
public class LibraryManagementSystem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(); // Instance of Library

        while (true) {
            // Display menu options
            System.out.println("==============================================");
            System.out.println("      DIGITAL LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search a Book");
            System.out.println("4. Update Book Status");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Prompt user for book details
                    System.out.print("Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String status = scanner.nextLine();
                    library.addBook(new Book(bookID, title, author, genre, status));
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title: ");
                    String searchQuery = scanner.nextLine();
                    Book book = library.searchBook(searchQuery);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("[ERROR] Book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateID = scanner.nextLine();
                    System.out.print("Enter new status (Available/Checked Out): ");
                    String newStatus = scanner.nextLine();
                    library.updateBook(updateID, newStatus);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteID = scanner.nextLine();
                    library.deleteBook(deleteID);
                    break;
                case 6:
                    System.out.println("[INFO] Exiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("[ERROR] Invalid choice! Try again.");
            }
        }
    }
}