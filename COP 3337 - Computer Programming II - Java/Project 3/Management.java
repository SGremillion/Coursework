/**
* The Management class extend the Business class and adds attributes:
*     engPrereq
* The toString() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Management extends Business {
   // variables
   private String engPrereq;
   
   // constructor
   public Management(String name, double gPA, int aCT, int year, String eng) {
      super(name, gPA, aCT, year); // sends data back to Business, which sends back to Major
      engPrereq = eng;
   }
   
   // setter for engPrereq
   public void setEngPrereq(String eng) {
      engPrereq = eng;
   }
   
   // getter for engPrereq
   public String getEngPrereq() {
      return engPrereq;
   }
   
   // toString override
   public String toString() {
      return( super.getName() + " major requires course prerequisite " + engPrereq);
   }
}