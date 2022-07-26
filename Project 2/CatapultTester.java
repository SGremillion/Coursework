/**
* The class test the Catapult object.
*
* The main() method reads the file with the data, creates a Catapult object, calls calculate() and getBestTraj()
*     to manipulate the object, then calls printTable() to print the data.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/06/26
*/

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class CatapultTester {

   public static void main(String[] args) throws IOException {
      // set variables
      int sets = 0;
      int temp = 0;
      int min = 0;
      int max = 0;
      int i, ii;
      int[] speedList, anglesList;
   
      // open file
      File file = new File("project_2_data.txt");
      if (!file.exists()) { 
         System.out.println("File does not exist.");// error if cannot find file
         System.exit(0);
      }
      
      // setup file scanner
      Scanner input = new Scanner(file);
      
      sets = input.nextInt(); // setting the amount of set to read and the number of times for the loop to run
      
      // loop for each set
      for(i = 0; i < sets; i++) {
         temp = input.nextInt(); // getting the quantity of speeds
         speedList = new int[temp]; // set size of speedList
         
         // loop for each speed
         for(ii = 0; ii < temp; ii++) {
            speedList[ii] = input.nextInt();
         }
         
         temp = input.nextInt(); // getting the quantity of angles
         anglesList = new int[temp]; // set size of anglesList
         for(ii = 0; ii < temp; ii++) {
            anglesList[ii] = input.nextInt();
         }
         
         min = input.nextInt(); // sets min trajectory
         max = input.nextInt(); // sets max trajectory
         
         Catapult projTable = new Catapult(speedList, anglesList, min, max);
         projTable.calculate(); // calculates the data for the table
         projTable.getBestTraj(); // finds the best trajectories         
         projTable.printTable(); // prints all of the information
      } 
      
      input.close(); // closes file
   }
}