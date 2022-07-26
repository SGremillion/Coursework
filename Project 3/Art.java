/**
* The Art class extend the English class and adds attributes:
*     prereq
* The toString() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Art extends English {
   // variables
   private String prereq;
   private String otherReq;
   
   // constructor
   public Art(String name, double gPA, int aCT, int engACT, String prerequisite, String other) {
      super(name, gPA, aCT, engACT); // sends data back to English, which sends back to Major
      otherReq = other;
   }
   
   // setter for prereq
   public void setPrereq() {
      prereq = "Art 101";
   }
   
   // setter for otherReq
   public void setOtherReq(String other) {
      otherReq = other;
   }
   
   // getter for prereq
   public String getPrereq() {
      return prereq;
   }
   
   // getter for otherReq
   public String getOtherReq() {
      return otherReq;
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requires course prerequisite " + this.getPrereq());
   }
}