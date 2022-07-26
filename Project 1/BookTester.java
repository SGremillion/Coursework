/**
* This tester BookTester reads and writes Book objects.
* It has an interactive menu to manipulate Book objects.
* 
* @author Stephanie Gremillion
* @ version 17.0.2
* @since 2022/06/24
*/

import java.util.ArrayList;
import java.util.Scanner;

public class BookTester {
   
   public static void main(String[] args) {
      // declare variables
      int mainMenuChoice = 0;
      String title = "temp";
      String author = "temp";
      String genre = "temp";
      String edition = "temp";
      int pages = 0;
      int rating = 0;
      int editBook = 0; // whick book user wants to edit
      Scanner input = new Scanner(System.in);
      String temp = "temp"; // for determining if user entered number
      int addSub = 0; // if user wants to add (0) or subtract (1) pages
      
      // setting and initializing default books
      ArrayList<Book> books = new ArrayList<Book>();
      books.add(new Book("Madame Bovary", "Gustave Flaubert", "Fiction", "First", 52, 5));
      books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "First", 0, 0));
      books.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", "Fiction", "First", 11, 5));
      books.add(new Book("Hamlet", "William Shakespeare", "Ficition", "Third", 5, 3));
      books.add(new Book("Moby Dick", "Herman Melville", "Fiction", "First", 0, 0));
      books.add(new Book("The Odyssey", "Homer", "Fiction", "First", 42, 4));
      
      // loop menu choices until exit
     do { // run main menu
     mainMenuChoice = mainMenu();
     
     // run menu choice
     System.out.println(); // empty line between menu and choice display
     switch(mainMenuChoice) {
         case 1:
            for(int i = 0; i < books.size(); i++) {
               System.out.println("Book " + (i+1) + ": ");
               System.out.println("Title: " + books.get(i).getTitle());
               System.out.println("Author: " + books.get(i).getAuthor());
               System.out.println("Genre: " + books.get(i).getGenre());
               System.out.println("Edition: " + books.get(i).getEdition());
               System.out.println("Pages Read: " + books.get(i).getPages());
               System.out.println("Rating: " + books.get(i).getRating() + "%");
               System.out.println();
            }
            break;
         case 2:
            // user enters new book information
            System.out.print("Enter Title: ");
            title = input.nextLine();
            System.out.print("Enter Author: ");
            author = input.nextLine();
            System.out.print("Enter Genre: ");
            genre = input.nextLine();
            System.out.print("Enter Edition: ");
            edition = input.nextLine();
            
            System.out.print("Enter Pages Read: ");
            temp = input.nextLine();
            while(temp.matches("[0-9]+") == false) { // confirming pages read input is number
               System.out.println("Please enter a number for Pages Read: ");
               temp = input.nextLine();
            }
            pages = Integer.parseInt(temp);
            
            System.out.print("Enter Rating (0 - 10): ");
            temp = input.nextLine();
            while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 0) || (Integer.parseInt(temp) > 10)) { // confirming rating input is number
               System.out.println("Please enter a valid number for Rating: ");
               temp = input.nextLine();
            }
            rating = Integer.parseInt(temp);
            System.out.println(); // empty line
            
            // adding new book to list
            books.add(new Book(title, author, genre, edition, pages, rating));
            
            // printing out book information for confirmation
            System.out.println("New Book Added: ");
            System.out.println("Title: " + books.get((books.size() - 1)).getTitle());
            System.out.println("Author: " + books.get((books.size() - 1)).getAuthor());
            System.out.println("Genre: " + books.get((books.size() - 1)).getGenre());
            System.out.println("Edition: " + books.get((books.size() - 1)).getEdition());
            System.out.println("Pages Read: " + books.get((books.size() - 1)).getPages());
            System.out.println("Rating: " + books.get((books.size() - 1)).getRating() + "%");
            System.out.println(); // empty line
            break;
         case 3:
            System.out.println("Which number book do you want to edit?");
            for(int x = 0; x < books.size(); x++) {
               System.out.println("Book " + (x + 1) + ": " + books.get(x).getTitle());
            }
            temp = input.nextLine();
            while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) <= 0) || (Integer.parseInt(temp) > books.size())) { // confirming number book input is number and valid
               System.out.println("Please enter a valid number: ");
               temp = input.nextLine();
            }
            editBook = Integer.parseInt(temp) - 1;
            System.out.println("\nWhat would you like to edit?");
            System.out.println("1. Title: " + books.get(editBook).getTitle());
            System.out.println("2. Author: " + books.get(editBook).getAuthor());
            System.out.println("3. Genre: " + books.get(editBook).getGenre());
            System.out.println("4. Edition: " + books.get(editBook).getEdition());
            System.out.println("5. Pages Read: " + books.get(editBook).getPages());
            System.out.println("6. Rating: " + books.get(editBook).getRating() + "%");
            temp = input.nextLine();
            while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 6)) { // confirming selection is number
               System.out.println("Please enter a valid number: ");
               temp = input.nextLine();
            }
            System.out.println(); // empty line
            switch(Integer.parseInt(temp)) {
               case 1:
                  System.out.println("Enter a new Title: ");
                  temp = input.nextLine();
                  books.get(editBook).setTitle(temp);
                  System.out.println("New Title: " + books.get(editBook).getTitle());
                  System.out.println(); // empty line
                  break;
               case 2:
                  System.out.println("Enter a new Author: ");
                  temp = input.nextLine();
                  books.get(editBook).setAuthor(temp);
                  System.out.println("New Author: " + books.get(editBook).getAuthor());
                  System.out.println(); // empty line
                  break;
               case 3:
                  System.out.println("Enter a new Genre: ");
                  temp = input.nextLine();
                  books.get(editBook).setGenre(temp);
                  System.out.println("New Genre: " + books.get(editBook).getGenre());
                  System.out.println(); // empty line
                  break;
               case 4:
                  System.out.println("Enter a new Edition: ");
                  edition = input.nextLine();
                  books.get(editBook).setEdition(edition);
                  System.out.println("New Edition: " + books.get(editBook).getEdition());
                  System.out.println(); // empty line
                  break;
               case 5:
                  System.out.println("What do you want to do?");
                  System.out.println("1. Add pages");
                  System.out.println("2. Subtract pages");
                  temp = input.nextLine();
                  while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) > 2) || (Integer.parseInt(temp) < 1)) {
                     System.out.println("Please enter a valid selection.");
                       temp = input.nextLine();
                  }
                  addSub = Integer.parseInt(temp);
                  if(addSub == 1) {
                     System.out.println("How many pages would you like to add?");
                     temp = input.nextLine();
                     while(temp.matches("[0-9]+") == false) {
                        System.out.println("Please enter a valid number.");
                        temp = input.nextLine();
                     }
                     books.get(editBook).changePages(Integer.parseInt(temp));
                     System.out.println("New amount of Pages Read: " + books.get(editBook).getPages());
                     System.out.println(); // empty line
                  }
                  else {
                     System.out.println("How many pages would you like to subtract?");
                     temp = input.nextLine();
                     while(temp.matches("[0-9]+") == false) {
                        System.out.println("Please enter a valid number.");
                        temp = input.nextLine();
                     }
                     while((books.get(editBook).getPages() - Integer.parseInt(temp)) < 0) {
                        System.out.println(books.get(editBook).getTitle() + " has " + books.get(editBook).getPages() + " pages read.");
                        System.out.println("Please enter a number less than " + books.get(editBook).getPages() + ".");
                        temp = input.nextLine();
                     }
                     books.get(editBook).changePages((Integer.parseInt(temp)) * -1);
                     System.out.println("New amount of Pages Read: " + books.get(editBook).getPages());
                     System.out.println(); // empty line 
                  }
                  break;
               case 6:
                  System.out.println("Enter a new Rating (0-10): ");
                  temp = input.nextLine();
                  while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 0) || (Integer.parseInt(temp) > 10)) { // confirming rating is number
                     System.out.println("Please enter a valid number (0-10).");
                     temp = input.nextLine();
                  }
                  books.get(editBook).changeRating(Integer.parseInt(temp));
                  System.out.println("New Rating: " + books.get(editBook).getRating() + "%");
                  System.out.println(); // empty line
                  break;
               default:
                  break;
            }
            break;
         default:
            break;
     }
     } while(mainMenuChoice != 4); // loop ends when user chooses 4 (exit)
   }
   
   public static int mainMenu() {
      // declare variables
      Scanner input = new Scanner(System.in);
      int choice;
      
      // show main menu options
      System.out.println("Please choose an option: ");
      System.out.println("1. Show Books");
      System.out.println("2. Add Book");
      System.out.println("3. Edit Book");
      System.out.println("4. Exit");
      
      // accept selection and return result to main
      choice = Integer.parseInt(input.nextLine());
      return choice;
   }
}