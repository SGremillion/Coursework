/**
* This is the H_Ornithiscian concrete class that extends Herbivore.
* 
* This class:
* ...has a constructor that sends the following variables to super 
*     (Herbivore): time, location, size, legs, teeth, weight, food.
* ...has appropriate getters that return type "Ornithiscian" as well as
*     returning the appropriate description.
* ...overrides toString() to display the base information about this
*     type of dino.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

public class H_Ornithiscian extends Herbivore {
   // constructor
   public H_Ornithiscian(String tim, String locate, double siz, int leg, String teet, int weigh, String foo) {
      super(tim, locate, siz, leg, teet, weigh, foo);
   }
   
   // getters
   public String getType() { return "Ornithiscian"; }
   public String getDescription() { return "herbivorous dinosaur with backward rotated pelvis"; }
   
   // override toString() method
   public String toString() {
      return("Type: " + this.getType() + " - " + this.getDescription() + "\n"
           + "Diet: " + super.getDiet() + "\n"
           + "Time period: " + super.getTime() + " million years ago\n"
           + "Location: " + super.getLocation() + "\n"
           + "Weight: " + super.getWeight() + "kg\n"
           + "Size: " + super.getSize() + "m\n"
           + "Walks on: " + super.getLegs() + " legs" + "\n"
           + "Eats: " + super.getFood() + "\n"
           + "Teeth: " + super.getTeeth() + "\n");
   }
}