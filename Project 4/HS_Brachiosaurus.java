/**
* This is the HO_Brachiosaurus concrete class that extends H_Sauropod
*     (which extends Herbivore).
* 
* This class:
* ...has a constructor that sends the following variables to super 
*     (H_Sauropod): time, location, size, legs, teeth, weight, food.
* ...has appropriate getters that return name, meaning, and person.
* ...overrides toString() to display all of the information about 
*     this dinosaur
* ...has printBrach() method that prints ASCII art of this dino.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

public class HS_Brachiosaurus extends H_Sauropod {
   // constructor
   public HS_Brachiosaurus(String tim, String locate, double siz, int leg, String teet, int weigh, String foo) {
      super(tim, locate, siz, leg, teet, weigh, foo);
   }
   
   // getters
   public String getName() { return "Brachiosaurus"; }
   public String getMeaning() { return "arm lizard"; }
   public String getPerson() { return "Riggs (1903)"; }
   
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
   
      // method to print brachiosaurus picture
      public void printBrach() {
      System.out.println();
      System.out.println("    (/((##&&%.                                                                  ");
      System.out.println("     (,   &#*/#%.                                                               ");
      System.out.println("            ((/###%                                                             ");
      System.out.println("              (#.&#%%,                                                          ");
      System.out.println("               */(*(%%%.                                                        ");
      System.out.println("                 //*@##%&                                                       ");
      System.out.println("                  /(/&###%%                                                     ");
      System.out.println("                   ./(/((#%%(                                                   ");
      System.out.println("                     (((#(((#%*                                                 ");
      System.out.println("                      ,/#/((((###                                               ");
      System.out.println("                        //#.#((#%%%                                             ");
      System.out.println("                         */(((((######.                                         ");
      System.out.println("                           (///(((/////(%,                                      ");
      System.out.println("                            *////*******/(##&                                   ");
      System.out.println("                             ***,**.,*(*//######(                               ");
      System.out.println("                              ,,,.**////(#(#(#####%&                            ");
      System.out.println("                              *,. ,*/**/((%%%###(######&                        ");
      System.out.println("                               &#((/,.*/#&#########%#(#%&&%%&                   ");
      System.out.println("                                *%&&.,/(@&%#####%%&&/(#%%&#%%###%*              ");
      System.out.println("                                 *%&,/(@@&&&&%%@@@@%*(%%       (@&###%&%/,      ");
      System.out.println("                                  &**/(%       %&@@,(%*                         ");
      System.out.println("                                 ((*(%.         &&@/(#                          ");
      System.out.println("                                ((*(@            .&/(#                          ");
      System.out.println("                                &/#%             #**(%                          ");
      System.out.println("                                 #@                                             ");
      System.out.println();
   }
}