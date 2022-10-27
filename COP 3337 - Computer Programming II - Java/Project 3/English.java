/**
* The English class extend the Major class and adds attributes:
*     englishACT
* The toString() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class English extends Major {
   // variables
   private int englishACT;
   
   // constructor
   public English(String name, double gPA, int aCT, int engACT) {
      super(name, gPA, aCT); // sends data back to Major
      englishACT = engACT;
   }
   
   // setter for englishACT
   public void setEngAct(int engACT) {
      englishACT = engACT;
   }
   
   // getter for engACT
   public int getEngAct() {
      return englishACT;
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requires English ACT score of " + englishACT);
   }
}