/**
* This tester DinosaurTester initializes and reads dinos.
* It has an interactive menu to display Herbivore and Carnivore objects.
*
* main() displays a numbered menu for the user to choose from. They can 
*     view dino list, view dino types, print a specific dino they choose,
*     print all herbivores, print all carnivores, compare herbivore sizes,
*     or compare carnivore sizes.
* printMainMenu() is a method that displays the options of the main menu.
* printDinos() accepts ArrayList<Dinosaur> and String type to display
*     certain categories of dinosaurs.
* compareResults() accepts ArrayList<Dinosaur>, two dinosaurs being
*     compared, and the result of the comparison. It prints the information
*     on which dino has the bigger size or if they are the same.
* printLogo() prints the ASCII logo at program startup "Welcome To Dino Park"
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DinosaurTester {
   public static void main(String[] args) {
      // set variables
      String temp;
      int mainMenu = 0;
      int chooseDino = 0;
      int dinoCompare = 0;
      int compareResult = 0;
      Scanner input = new Scanner(System.in);
      ArrayList<Dinosaur> dino = new ArrayList<Dinosaur>();
      
      // setting and initializing default dinos
      dino.add(new CT_Spinosaurus("95 - 70", "Egypt and Morocco", 18.0, 2, "flat and blade-like", 4000, "fish and maybe other dinosaurs"));
      dino.add(new CT_Velociraptor("74 - 70", "Mongolia", 1.8, 2, "lots of sharp, pointed teeth", 7, "other animals"));
      dino.add(new CH_Herrerasaurus("228 - 200", "South and North America", 6.0, 2, "large teeth", 350, "other animals"));
      dino.add(new CH_Staurikosaurus("228 - 200", "South and North America", 2.1, 2, "serrated, laterally compressed, and caudally curved", 12, "smaller prey"));
      dino.add(new HO_Agilisaurus("169 - 159", "China", 1.5, 2, "leaf-shaped", 40, "leaves"));
      dino.add(new HO_Lesothosaurus("213 - 200", "Lesotho", 1.0, 2, "small, grinding teeth", 10, "plant material"));
      dino.add(new HS_Brachiosaurus("155 - 140", "Algeria, Protugal, Tanzania, and USA", 30.0, 4, "large, spoon-shaped", 400, "plant material"));
      dino.add(new HS_Bellusaurus("180 - 159", "China", 5.0, 4, "unknown", 0, "plants"));
      
      // printing dino park logo
      printLogo();
      
      //menu loop until user chooses exit
      do {
         mainMenu = 0;
         System.out.println();
         printMainMenu();
         temp = input.next();
         if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 9)) { // error if invalid selection
            System.out.println("Please enter a valid selection.\n");
         }
         else {
            mainMenu = Integer.parseInt(temp);
         }
         
         switch(mainMenu) {
         
            // View Dinosaur List
            case 1:
               System.out.println();
               
               printDinos(dino, "List All");
               break;
               
            // View Dinosaur Types
            case 2:
               System.out.println();
               printDinos(dino, "Types");
               break;
               
            // Print Dinosaur
            case 3:
               System.out.println();
               do{ // repeat until valid selection
                  chooseDino = 0;
                  System.out.println("Choose a dinosaur: ");
                  printDinos(dino, "List All Num");
                  temp = input.next();
                  if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 9)) { // error if invalid selection
                     System.out.println("Please enter a valid selection.\n");
                  }
                  else {
                     chooseDino = Integer.parseInt(temp);
                  }
               } while((chooseDino < 1) || (chooseDino > 9));
               
               System.out.println();
               if(chooseDino != 9) {
                  switch(chooseDino) { // printing picture before dino
                     case 1:
                        ((Carnivore)dino.get(chooseDino - 1)).printSpino();
                        break;
                     case 2:
                        ((Carnivore)dino.get(chooseDino - 1)).printVelo();
                        break;
                     case 3:
                        ((Carnivore)dino.get(chooseDino - 1)).printHerr();
                        break;
                     case 4:
                        ((Carnivore)dino.get(chooseDino - 1)).printStaur();
                        break;
                     case 5:
                        ((Herbivore)dino.get(chooseDino - 1)).printAgil();
                        break;
                     case 6:
                        ((Herbivore)dino.get(chooseDino - 1)).printLes();
                        break;
                     case 7:
                        ((Herbivore)dino.get(chooseDino - 1)).printBrach();
                        break;
                     case 8:
                        ((Herbivore)dino.get(chooseDino - 1)).printBell();
                        break;
                     default:
                        break;
                  }
                  System.out.println((dino.get(chooseDino - 1)).toString()); // print dino selected  
               }        
               else { // if user chose to print all dinos
                  System.out.println();
                  printDinos(dino, "Herbivore");
                  printDinos(dino, "Carnivore");
               }
               break; 
               
            // Print Herbivores
            case 4:
               System.out.println();
               printDinos(dino, "Herbivore");
               break;
               
            // Print Carnivores
            case 5:
               System.out.println();
               printDinos(dino, "Carnivore");
               break;
               
            // Compare Herbivores Size
            case 6:
               // choose first dino to compare
               do { // repeat until valid selection
                  chooseDino = 0;
                  System.out.println();
                  System.out.println("Choose a dinosaur to compare: ");
                  printDinos(dino, "Choose Herb");
                  temp = input.next();
                  if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 4)) { // error if invalid selection
                     System.out.println("Please enter a valid selection.\n");
                  }
                  else {
                     chooseDino = Integer.parseInt(temp);
                  }
               } while((chooseDino < 1) || (chooseDino > 4));
               
               // choose second dino to compare
               do { // repeat until valid selection
                  dinoCompare = 0;
                  System.out.println();
                  System.out.println("Choose a dinosaur to compare: ");
                  printDinos(dino, "Choose Herb");
                  temp = input.next();
                  if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 4)) { // error if invalid selection
                     System.out.println("Please enter a valid selection.\n");
                  }
                  else {
                     dinoCompare = Integer.parseInt(temp);
                  }
               } while((dinoCompare < 1) || (dinoCompare > 4));
               
               // compare the two dinos then print
               System.out.println();
               compareResult = ((Herbivore)dino.get(chooseDino + 3)).compareTo((Herbivore)dino.get(dinoCompare + 3));
               compareResults(dino, chooseDino + 3, dinoCompare + 3, compareResult);
               break;
               
            // Compare Carnivores Size
            case 7:
               // choose first dino to compare
               do { // repeat until valid selection
                  chooseDino = 0;
                  System.out.println();
                  System.out.println("Choose a dinosaur to compare: ");
                  printDinos(dino, "Choose Carn");
                  temp = input.next();
                  if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 4)) { // error if invalid selection
                     System.out.println("Please enter a valid selection.\n");
                  }
                  else {
                     chooseDino = Integer.parseInt(temp);
                  }
               } while((chooseDino < 1) || (chooseDino > 4));
               
               // choose second dino to compare
               do { // repeat until valid selection
                  dinoCompare = 0;
                  System.out.println();
                  System.out.println("Choose a dinosaur to compare: ");
                  printDinos(dino, "Choose Carn");
                  temp = input.next();
                  if((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < 1) || (Integer.parseInt(temp) > 4)) { // error if invalid selection
                     System.out.println("Please enter a valid selection.\n");
                  }
                  else {
                     dinoCompare = Integer.parseInt(temp);
                  }
               } while((dinoCompare < 1) || (dinoCompare > 4));
               
               // compare the two dinos then print
               System.out.println();
               compareResult = ((Carnivore)dino.get(chooseDino - 1)).compareTo((Carnivore)dino.get(dinoCompare - 1));
               compareResults(dino, chooseDino - 1, dinoCompare - 1, compareResult);
               break;
               
            // Exit
            case 8:
               break;
               
            default:
               break;
         }
      } while(mainMenu != 8);
   }
   
   
   // method to display main menu
   public static void printMainMenu() {
      System.out.println("Main Menu");
      System.out.println("------------");
      System.out.println("1. View Dinosaur List");
      System.out.println("2. View Dinosaur Types");
      System.out.println("3. Print Dinosaur");
      System.out.println("4. Print Herbivores");
      System.out.println("5. Print Carnivores");
      System.out.println("6. Compare Herbivores Size");
      System.out.println("7. Compare Carnivores Size");
      System.out.println("8. Exit");
   }
   
   // method to print dinos, accepts limitations (both types, one type, or numbered for choosing)
   public static void printDinos(ArrayList<Dinosaur> dino, String type) {
      // variables
      int count = 1;
      
      for(int i = 0; i < 8; i++) { // goes through the list of all dinos
         if(type.equals("Types")) { // if printing list of dino types
            System.out.println(((dino.get(i)).getType()) + " - " + ((dino.get(i)).getDescription()));
            i++;
         }
         else if(type.equals("List All")) { // if printing list of dinos
            System.out.println((dino.get(i)).getName());
         }
         else if(type.equals("List All Num")) { // if printing list of dinos to choose from
            System.out.println(count + ". " + (dino.get(i)).getName());
            count++;
         }
         else if((((dino.get(i)).getDiet()).equals(type))) { // if "type" matches dino type
            System.out.println((dino.get(i)).toString());
         }
         else if(type.equals("Choose Herb") && (((dino.get(i)).getDiet()).equals("Herbivore"))) { // if printing herbivores to choose from
            System.out.println(count + ". " + (dino.get(i)).getName());
            count++;
         }
         else if(type.equals("Choose Carn") && (((dino.get(i)).getDiet()).equals("Carnivore"))) { // if printing carnivores to choose from
            System.out.println(count + ". " + (dino.get(i)).getName());
            count++;
         }
      }
      if(type.equals("List All Num")) { // append to end if listing all to choose
         System.out.println("9. Print All");
      }
   }
   
   // method to print compare result
   public static void compareResults(ArrayList<Dinosaur> dino, int dinoOne, int dinoTwo, int result) {
      switch(result) {
         case -1: // dinoTwo is greater than dinoOne
            System.out.println((dino.get(dinoTwo)).getName() + " has a size of " + (dino.get(dinoTwo)).getSize()
                              + "m which is greather than " + (dino.get(dinoOne)).getName()
                              + "'s size of " + (dino.get(dinoOne)).getSize() + "m.\n");
            break;
         case 0: // dinoOne and dinoTwo are equal
            System.out.println((dino.get(dinoOne)).getName() + " and " + (dino.get(dinoTwo)).getName()
                              + " have the same size of " + (dino.get(dinoOne)).getSize() + "m.");
            break;
         case 1: // dinoOne is greater than dinoTwo
            System.out.println((dino.get(dinoOne)).getName() + " has a size of " + (dino.get(dinoOne)).getSize()
                              + "m which is greather than " + (dino.get(dinoTwo)).getName()
                              + "'s size of " + (dino.get(dinoTwo)).getSize() + "m.\n");
            break;
         default:
            break;
      }
   }
   
   // method to display dino park logo
   public static void printLogo() {
      System.out.println("__      __    _                      _ _ _     ");
      System.out.println("\\ \\    / /_ _| |__ _ _ _ _    _ _   |_   _|__  ");
      System.out.println(" \\ \\/\\/ // -_) / _/ _ \\ '  \\ / -_)    | |/ _ \\ ");
      System.out.println("  \\_/\\_/ \\___|_\\__\\___/_|_|_|\\___|    |_|\\___/ ");
            
      System.out.println("              .=-.-..-._          _,.---._                _ __    ,---.                  ,--.-.,-.  ");
      System.out.println("  _,..---._  /==/_ /==/ \\  .-._ ,-.' , -  `.           .-`.' ,`..--.'  \\      .-.,.---. /==/- |\\  \\ ");
      System.out.println("/==/,   -  \\|==|, ||==|, \\/ /, /==/_,  ,  - \\         /==/, -   \\==\\-/\\ \\    /==/  `   \\|==|_ `/_ / ");
      System.out.println("|==|   _   _\\==|  ||==|-  \\|  |==|   .=.     |       |==| _ .=. /==/-|_\\ |  |==|-, .=., |==| ,   /  ");
      System.out.println("|==|  .=.   |==|- ||==| ,  | -|==|_ : ;=:  - |       |==| , '=',\\==\\,   - \\ |==|   '='  /==|-  .|   ");
      System.out.println("|==|,|   | -|==| ,||==| -   _ |==| , '='     |       |==|-  '..'/==/ -   ,| |==|- ,   .'|==| _ , \\  ");
      System.out.println("|==|  '='   /==|- ||==|  /\\ , |\\==\\ -    ,_ /        |==|,  |  /==/-  /\\ - \\|==|_  . ,'./==/  '\\  | ");
      System.out.println("|==|-,   _`//==/. //==/, | |- | '.='. -   .'         /==/ - |  \\==\\ _.\\=\\.-'/==/  /\\ ,  )==\\ /\\=\\.' ");
      System.out.println("`-.`.____.' `--`-` `--`./  `--`   `--`--''           `--`---'   `--`        `--`-`--`--' `--`       ");
   }
}