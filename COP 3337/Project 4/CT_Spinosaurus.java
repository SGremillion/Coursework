/**
* This is the CT_Spinosaurus concrete class that extends C_Theropod
*     (which extends Carnivore).
* 
* This class:
* ...has a constructor that sends the following variables to super 
*     (C_Theropod): time, location, size, legs, teeth, weight, food.
* ...has appropriate getters that return name, meaning, and person.
* ...overrides toString() to display all of the information about 
*     this dinosaur
* ...has printSpino() method that prints ASCII art of this dino.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

public class CT_Spinosaurus extends C_Theropod {
   // constructor
   public CT_Spinosaurus(String tim, String locate, double siz, int leg, String teet, int weigh, String foo) {
      super(tim, locate, siz, leg, teet, weigh, foo);
   }
   
   // getters
   public String getName() { return "Spinosaurus"; }
   public String getMeaning() { return "thorn lizard"; }
   public String getPerson() { return "Stromer (1915)"; }
   
   // override toString() method
   public String toString() {
      return("Name: " + this.getName() + ", which means \"" + this.getMeaning() + "\"\n"
           + "Named by: " + this.getPerson() + "\n"
           + "Type: " + super.getType() + " - " + super.getDescription() + "\n"
           + "Diet: " + super.getDiet() + "\n"
           + "Time period: " + super.getTime() + " million years ago\n"
           + "Location: " + super.getLocation() + "\n"
           + "Weight: " + super.getWeight() + "kg\n"
           + "Size: " + super.getSize() + "m\n"
           + "Walks on: " + super.getLegs() + " legs" + "\n"
           + "Eats: " + super.getFood() + "\n"
           + "Teeth: " + super.getTeeth() + "\n");
   }
   
   // method to print spinosaurus picture
   public void printSpino() {
      System.out.println();
      System.out.println("                                     /###((%#%##                                ");
      System.out.println("                                  *%(*,,,,,,,*,*%%(          #(##%#%%%%(        ");
      System.out.println("                                 #%**,,,,,*,**/**(#&,       #(/#(#(#(#(%%**     ");
      System.out.println("                                &(**(#%&&&&%###(#%%%&&(    //((((/(###& ,%(#%%/,");
      System.out.println("                               #%#%&(//(//#(%(###(#%#(##(#%((((/.   *(##,,     (");
      System.out.println("                            *##%##/#((%%%%%%%%#(#%(###(#//#(//*         ,#(.    ");
      System.out.println("                        ##%%####((/####%#/(##((///((###/*/((.              ,    ");
      System.out.println("                  ,(%%#%(#(#((((///((/**/#(/###(((###(*/((#                     ");
      System.out.println("            .##(####(((/*///***/*/*,//**,/((/*((////***/**####                  ");
      System.out.println("         (%((///(//*/****//****,   .(/*/****/**((((/        ##                  ");
      System.out.println("      /(((///                          ,/(/((/*(##(                             ");
      System.out.println("    (##(.                             **/((*//(##(*                             ");
      System.out.println("  *((,                                /((((, (###*                              ");
      System.out.println(" (#                                  (#%%    %##%                               ");
      System.out.println("*,                                   (%%%     ,####%##,                         ");
      System.out.println("                                      *#(##((.  ..,(%//                         ");
      System.out.println("                                       .,#&**,*                                 ");
      System.out.println();
   }
}