/**
* The Math class extend the Major class and adds attributes:
*     mathACT
* The toString() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Math extends Major {
   // variables
   private int mathACT;
   
   // constructor
   public Math(String name, double gPA, int aCT, int matACT) {
      super(name, gPA, aCT); // sends data back to Major
      mathACT = matACT;
   }
   
   // setter for mathACT
   public void setMathAct(int matACT) {
      mathACT = matACT;
   }
   
   // getter for mathACT
   public int getMathAct() {
      return mathACT;
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requires Math ACT score of " + mathACT);
   }
}