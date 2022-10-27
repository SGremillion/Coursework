/**
* This class ParkingLot keeps tracks of cars parked and in queue for a
* parking lot. It accepts the following:
*     5 digit license plate number - 
*        determines whether or not the car the car is already in the
*           parking lot or queue
*        determines if the car has a valid decal to park
*        determines if the lot is full (sends car to queue) or if it
*           can park
*     negative 5 digit license plate number - 
*        determines whether or not the car is in the parking lot or
*           queue
*        removes car from queue
*        puts cars from lot onto street, removes car from lot, puts
*           cars from street back into lot
*     0 - exits the program
*
*  printCars(Stack<Integer>, Queue<Integer<>) method prints out each
*     car in the lot and queue
*
*  parkCarCheck(Stack<Integer> lot, Queue<Integer> queue, int plate, 
*     int decal, boolean negative) method checks what to do with
*     the user input information - 
*        return 1 if car is already in lot or queue (if adding), if
*           car is not in lot or queue (if removing), or if decal is
*           invalid
*        return 2 if adding car to lot
*        return 3 if adding car to queue because lot is full
*        return 4 if removing car from lot
*        return 5 if removing car from queue
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/25
*/

import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ParkingLot {
   public static void main(String[] args) {
      // variables
      Random rand = new Random();
      int plate;
      boolean negative = false;
      int result;
      String temp;
      Scanner input = new Scanner(System.in);
      Stack<Integer> lot = new Stack<>();
      Stack<Integer> street = new Stack<>();
      Queue<Integer> queue = new LinkedList<>();
      
      // adding first 10 cars
      for(int i = 0; i < 15; i++) {
         plate = rand.nextInt(90000); // creating a new license plate
         while(lot.contains(plate)) { // if parking lot already has plate, make new plate
            plate = rand.nextInt(90000);
         }
         lot.push(plate); // adding plate to parking lot
      }
      
      printCars(lot, queue);
      
      do {
         // display
         System.out.println("Please enter your license plate number.");
         System.out.println("Start with - if you wish to remove your car or enter 0 to exit.");
         temp = input.next();
         
         // checking if negative
         negative = false;
         if(temp.startsWith("-")) {
            temp = temp.substring(1);
            negative = true;
         }
         
         // checking if valid
         if(Integer.parseInt(temp) != 0) {
            while((temp.matches("[0-9]+") == false) || (Integer.parseInt(temp) < -99999) || (Integer.parseInt(temp) > 99999) || (temp.length() < 5)) { // error if invalid selection
               System.out.println("Please enter a valid number.");
               temp = input.next();
               negative = false;
               if(temp.startsWith("-")) {
                  temp = temp.substring(1);
                  negative = true;
               }
            }
         }
         plate = Integer.parseInt(temp);
         result = parkCarCheck(lot, queue, plate, rand.nextInt(), negative); // checking what happens to car
               
         switch(result) {
            case 2: // car goes in lot
               lot.push(plate);
               break;
            case 3: // car goes in queue
               queue.add(plate);
               break;
            case 4: // remove car from lot
               while(lot.peek() != (plate)) { // putting cars on street
                  street.push(lot.pop());
               }
               lot.pop(); // removes car
               while(street.size() > 0) {
                  lot.push(street.pop()); // putting cars back in lot
               }
               
               if((lot.size() < 15) && (queue.size() > 0)) { // if room in lot, add from queue
                  System.out.print("Car " + queue.peek() + " from queue has been added to parking lot.\n");
                  lot.add(queue.remove());
               }
               break;
            case 5: // remove car from queue
               for(int i = 0; i < queue.size(); i++) {
                  if(queue.peek() == plate) { queue.remove(); }
                  else { queue.add(queue.poll()); }
               }
               break;
            default:
               break;
         }
         System.out.println();
         printCars(lot, queue);
      } while(plate != 0);

   }
   
   public static void printCars(Stack<Integer> lot, Queue<Integer> queue) {
      // printing parking lot
      System.out.println("Parking Spaces: " + (15 - lot.size()) + "/15 Spaces Available");
      System.out.println("-------------------------------------");
      lot.forEach(car -> {
         System.out.printf("%05d\n", car);
      });
      System.out.println();
      
      // printing car queue
      System.out.println("Cars in Queue");
      System.out.println("-------------");
      if(queue.size() == 0) { System.out.println("Empty"); }
      else {
         for(Integer next : queue) {
            System.out.printf("%05d\n", next);
         }
      }
      System.out.println();
   }
   
   public static int parkCarCheck(Stack<Integer> lot, Queue<Integer> queue, int plate, int decal, boolean negative) {
      int result = 0;
      
      if(plate == 0) { result = 1; } // if exit
      else if(negative == false) { // if add car
        if(lot.contains(plate)) { // if already in lot
            System.out.println("Your car is already parked in the parking lot.\n");
            result = 1;
         }
         else if(queue.contains(plate)) { // if already in queue
            System.out.println("Your car is already in the queue.\n");
            result = 1;
         }
         else if(decal % 2 != 0) { // if improper decal
            System.out.println("Checking decal...");
            System.out.println("Sorry, your car does not have the proper decal for this parking lot.\n");
            result = 1;
         }
         else if(lot.size() < 15) { // if lot has room
            System.out.println("Checking decal...");
            System.out.println("Your decal is valid. Your car has been parked in the lot.\n");
            result = 2; 
         }
         else { // if lot is full
            System.out.println("Checking decal...");
            System.out.println("Your decal is valid. The parking lot is full. Your car has been added to the queue.\n");
            result = 3; 
         }
      }
      else { // if remove car
         if(lot.contains(plate)) { // remove car from lot
            System.out.println("Your car has been removed from the parking lot.\n");
            result = 4; 
         } 
         else if(queue.contains(plate)) { // remove car from queue
            System.out.println("Your car has been removed from the queue.\n");
            result = 5; 
         } 
         else { // if car is not in lot or queue
            System.out.println("Your car is not in the parking lot or queue.\n");
            result = 1;
         }
      }
      
      return result;
   }
}