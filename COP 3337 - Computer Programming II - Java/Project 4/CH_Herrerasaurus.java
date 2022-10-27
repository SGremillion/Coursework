/**
* This is the CH_Herrerasaurus concrete class that extends C_Herrerasauridus
*     (which extends Carnivore).
* 
* This class:
* ...has a constructor that sends the following variables to super 
*     (C_Herrerasauridus): time, location, size, legs, teeth, weight, food.
* ...has appropriate getters that return name, meaning, and person.
* ...overrides toString() to display all of the information about 
*     this dinosaur
* ...has printHerr() method that prints ASCII art of this dino.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

public class CH_Herrerasaurus extends C_Herrerasauridus {
   // constructor
   public CH_Herrerasaurus(String tim, String locate, double siz, int leg, String teet, int weigh, String foo) {
      super(tim, locate, siz, leg, teet, weigh, foo);
   }
   
   // getters
   public String getName() { return "Herrerasaurus"; }
   public String getMeaning() { return "Herrera's lizard"; }
   public String getPerson() { return "Reig (1959)"; }
   
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
   
      // method to print herrerasaurus picture
      public void printHerr() {
      System.out.println();
      System.out.println("                @(#&&. , (                                                      ");
      System.out.println("                %#(((/%&@%(##                                                   ");
      System.out.println("           @(/@&#(#&%#*(/(/*(/%(,                                               ");
      System.out.println("      %&%@&(&(#(*/#/ ,*/(// **((*#(**(,//                                       ");
      System.out.println(" #%&&// .*.&&&@@.&%#((%*&*&&&&#**(&&%((##*(/#(#/((                     %##%#% @*");
      System.out.println(" ##/% * ..     /&/*&(        (%(#*(#(%%&&#/(%%((#((#/((#(         &/##%%%&      ");
      System.out.println("               *(##           #&#(/(((&%%#%*&@/###/((%#(%##((%#*(%&%%%#         ");
      System.out.println("               %#(           #(%@%&%@@%(#&&%&&@&%%#@@@@&##&&%%#####%,           ");
      System.out.println("             *,#             /@*  &@@@@@%%#(%#%@&@&%@@@&&#((*((##               ");
      System.out.println("             #*             %#         %#&&/,((@&&&#&(///(                      ");
      System.out.println("                           %&        &%%  @@(%/.@@&%(                           ");
      System.out.println("                          #&/        (#(      &@@@#%(                           ");
      System.out.println("                          @          %&@       @####%#/                         ");
      System.out.println("                                     &%        ##&%@@@%#                        ");
      System.out.println("                                               #@&%    @&&%(                    ");
      System.out.println("                                              @&@@#      @&%                    ");
      System.out.println("                                               @& %#     (((#                   ");
      System.out.println("                                                %&*     /((##                   ");
      System.out.println();
   }
}