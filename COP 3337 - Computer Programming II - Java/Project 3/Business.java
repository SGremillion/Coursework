/**
* The Business class extend the Major class and adds attributes:
*     corePrereq
* The toString() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Business extends Major {
   // variables
   private String corePrereq;
   private int year;
   
   // constructor
   public Business(String name, double gPA, int aCT, int classYear) {
      super(name, gPA, aCT); // sends data back to Major
      year = classYear;
   }
   
   // setter for corePrereq
   public void setPrereq() {
      corePrereq = "Speech 101";
   }
   
   // setter for year
   public void setYear(int classYear) {
      year = classYear;
   }
   
   // getter for corePrereq
   public String getPrereq() {
      return corePrereq;
   }
   
   // getter for year
   public int getYear() {
      return year;
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requires course prerequisite " + this.getPrereq());
   }
}