/**
* The ComputerScience class extend the Math class and adds attributes:
*     permission, mathPrereq
* The toString() method in this class overrides the default method.
* The setPermUnreq() method in this class sets "permission" variable to "Advisor Permission Unrequired"
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class ComputerScience extends Math {
   // variables
   private String permission;
   private String mathPrereq;
   
   // constructor
   public ComputerScience(String name, double gPA, int aCT, int matACT, String perm, String mathPre) {
      super(name, gPA, aCT, matACT); // sends data back to Math, which sends back to Major
      permission = perm;
      mathPrereq = mathPre;
   }
   
   // setter for permission
   public void setPermission(String perm) {
      permission = perm;
   }
   
   // setter for mathPrereq
   public void setMathPrereq(String mathPre) {
      mathPrereq = mathPre;
   }
   
   // getter for permission
   public String getPermission() {
      return permission;
   }
   
   // getter for mathPrereq
   public String getMathPrereq() {
      return mathPrereq;
   }
   
   // setting permission unrequired
   public void setPermUnreq() {
      permission = "Advisor Permission Unrequired";
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requirements: " + permission + " and " + mathPrereq );
   }
}