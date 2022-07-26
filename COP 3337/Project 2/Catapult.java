/**
* The Catapult object takes a series of data (speeds and angles) and determines if they can hit
* a target distance (between min and max).
*
* The constructor accepts an array of speeds, and array of angles, a minimum, and a maximum trajectory.
* The method calculate() uses the trajectory of a projectile formula to calculate each speed and
*     angle combination, putting it all into a multidimensional array.
* The method getBestTraj() determines if any of the possible combinations are within the min and max
*     range. If so, it adds the speed, angle, and distance into an arraylist.
* The method printTable() takes all of the information from the constructor and previously mentioned
*     methods and prints them out in a readable table.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/06/26
*/

import java.lang.Math;
import java.util.ArrayList;
import java.util.*;

public class Catapult {
   
   // set variables
   private int[] speeds, angles; // arrays that store the accepted speeds and angles
   private double[][] calculations; // 2D array for the calculated combinations of speed and angles
   private int min, max; // the min and max distances
   private ArrayList<Integer> bestTraj = new ArrayList<Integer>(); // list of best trajectories after calculations
   private boolean noBestTraj = false; // determines if there is a best trajectory or not
   
   
   
   // constructor
   public Catapult(int[] speedList, int[] anglesList, int mn, int mx) {
      min = mn;
      max = mx;
      
      speeds = new int[speedList.length];
      for(int i = 0; i < speeds.length; i++) { // filling speeds array
         speeds[i] = speedList[i];
      }
      
      angles = new int[anglesList.length];
      for(int i = 0; i < angles.length; i++) { // filling angles array
         angles[i] = anglesList[i];
      }
   }
   
   
   
   // method to calculate each speed and angle combination
   public void calculate() {
      calculations = new double[speeds.length][angles.length];
      for(int i = 0; i < speeds.length; i++) {
         for(int ii = 0; ii < angles.length; ii++) {
            calculations[i][ii] = (Math.pow(speeds[i], 2) * Math.sin(Math.toRadians(angles[ii]) * 2.0) / Math.pow(9.8, 2));
         }
      }
   }
   
   
   
   // method to determine if there are any combinations that fit the distination
   public void getBestTraj() {
      // set variables
      int x = 0; // for counting if there are any data within range
      for(int i = 0; i < speeds.length; i++) {
         for(int ii = 0; ii < angles.length; ii++) {
            if((calculations[i][ii] > min) && (calculations[i][ii] < max)) {
               bestTraj.add(speeds[i]); // adding speeds coordinate to correspond with correct trajectory
               bestTraj.add(angles[ii]); // adding angles coordinate to correspond with correct trajectory
               bestTraj.add((int)calculations[i][ii]); // adding landing point for correct trajectory
               x++;
            }
         }
      }
      if(x == 0) { // if there are no trajectories stored, will output such at printTable
         noBestTraj = true;
      }
   }
   
   
   
   // method to print the projectile table
   public void printTable() {
      //set variables
      int i, ii;
   
      // printing header and degrees
      System.out.println("\t\tProjectile Table");
      System.out.println("---------------------------");
      System.out.printf("%-10s", "Speed");
      for(i = 0; i < angles.length; i++) {
         System.out.printf("%10s", (String.valueOf(angles[i]) + " deg"));
      }
      System.out.println(); // next line
      
      // printing subsequent lines of table
      for(i = 0; i < speeds.length; i++) {
         System.out.printf("%10d", speeds[i]);
         for(ii = 0; ii < angles.length; ii++) {
            System.out.printf("%10.3f", calculations[i][ii]);
         }
         System.out.println(); // next line
      }
      
      // printing footer
      System.out.println("---------------------------");
      if(noBestTraj == false) { // if there are viable combinations...
         int y = 0; // for counting how many bestTraj coordinates have been printed
         System.out.println("Best Trajectory Values:");
         for(i = 0; i < bestTraj.size(); i+=3) {
            System.out.print("(Speed: " + bestTraj.get(i));
            System.out.print(", " + bestTraj.get(i+1) + " deg) = ");
            System.out.print(bestTraj.get(i+2) + "m   ");
            y++;
            if((y%5 == 0) && (i+3 < bestTraj.size())) { // making a line break after each 5th coordinates printed
               System.out.println(); // next line
            }
         }
         System.out.println(); // next line
      }
      else { // if there are no viable combinations...
         System.out.println("No viable launch available for these combinations.");
      }
      System.out.println("---------------------------");
      System.out.println(); // empty line
   }
}