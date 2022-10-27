/**
* This is the Carnivore abstract class that implements Dinosaur interface
*     and Comparable<T> interface. C_Theropod and C_Herrerasauridus extend 
*     this class.
* 
* This class:
* ...contains the all of the shared instance variables for all of
*     the Carnivores: diet, time, location, size, legs, teeth, weight, food.
* ...has a constructor that initializees all of the above instance 
*     variables, also setting diet to the appropriate "Carnivore".
* ...contains all of the setters and getters for the above instance
*     variables.
* ...overrides the compareTo() method to compare two dino's sizes.
* ...contains method headers for its subclasses.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

abstract class Carnivore implements Dinosaur, Comparable<Carnivore> {
   // variables
   private String diet;
   private String time;
   private String location;
   private double size;
   private int legs;
   private String teeth;
   private int weight;
   private String food;
   
   // constructor
   public Carnivore(String tim, String locate, double siz, int leg, String teet, int weigh, String foo) {
      diet = "Carnivore";
      time = tim;
      location = locate;
      size = siz; 
      legs = leg;
      teeth = teet;
      weight = weigh;
      food = foo;
   }
   
   // setters
   public void setDiet(String d) { diet = d; }
   public void setTime(String ti) { time = ti; }
   public void setLocation(String lo) { location = lo; }
   public void setSize(double s) { size = s; }
   public void setLegs(int le) { legs = le; }
   public void setTeeth(String t) { teeth = t; }
   public void setWeight(int w) { weight = w; }
   public void setFood(String f) { food = f; }
   
   // getters
   public String getDiet() { return diet; }
   public String getTime() { return time; }
   public String getLocation() { return location; }
   public double getSize() { return size; }
   public int getLegs() { return legs; }
   public String getTeeth() { return teeth; }
   public int getWeight() { return weight; }
   public String getFood() { return food; }
   
   // overriding compareTo() method
   public int compareTo(Carnivore dino) {
      if(this.size > dino.size) {
         return 1;
      }
      else if (this.size < dino.size) {
         return -1;
      }
      else {
         return 0;
      }
   }
   
   //subclass class method headers
   public String getName() { return ""; }
   public String getMeaning() { return ""; }
   public String getPerson() { return ""; }
   public void printSpino() {} ;
   public void printVelo() {};
   public void printHerr() {};
   public void printStaur() {};
}