/**
* The Major class creates a new major with attributes:
*     name, GPA, ACT
* This class also creates the method prototypes used for the subclasses.
* The equals() method in this class overrides the default method.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Major {
   // variables
   private String majorName;
   private double majorGPA;
   private int majorACT;
   private String majorPrereq;

   // constructor
   public Major(String name, double gPA, int aCT) {
      majorName = name;
      majorGPA = gPA;
      majorACT = aCT;
   }
   
   // setter for majorName
   public void setName(String name) {
      majorName = name;
   }
   
   // setter for majorGPA
   public void setGPA(double gPA) {
      majorGPA = gPA;
   }
   
   // setter for majorACT
   public void setACT(int aCT) {
      majorACT = aCT;
   }
   
   // setter for prereq
   public void setPrereq() {
      majorPrereq = "None";
   }
   
   // getter for majorName
   public String getName() {
      return majorName;
   }
   
   // getter for majorGPA
   public double getGPA() {
      return majorGPA;
   }
   
   // getter for majorACT
   public int getACT() {
      return majorACT;
   }
   
   // getter for prereq
   public String getPrereq() {
      return majorPrereq;
   }
   
   // equals override
   public String equals(String compareName, double compareGPA, int compareACT) {
      String temp = "";
      if((this.getName().compareTo(compareName) == 0) && (Double.compare(this.getGPA(), compareGPA) == 0) && (this.getACT() == compareACT)) {
         temp = (this.getName() + " and " + compareName + " are the same major.");
      }
      else {
         temp = (this.getName() + " and " + compareName + " are not the same major.");
      }
      return temp;
   }
   
   // setting method prototypes for subclasses
   public void setEngAct(int x) {};
   public int getEngAct() { return 0; };
   public void setMathAct(int x) {};
   public int getMathAct() { return 0; };
   public void setCorePrereq(String x) {};
   public String getCorePrereq() { return ""; };
   public void setPermission(String x) {};
   public String getPermission() { return ""; };
   public void setMathPrereq(String x) {};
   public String getMathPrereq() { return ""; };
   public void setPermUnreq() {};
   public void setEngPrereq(String x) {};
   public String getEngPrereq() { return ""; };
   public void setStatsPrereq(String x) {};
   public String getStatsPrereq() { return ""; };
   public void setLanguage(String x) {};
   public String getLanguage() { return ""; };
   public void setLangUnreq() {};
   public int getYear() { return 0; };
   public void setYear(int x) {};
   public String getOtherReq() { return ""; };
   public void setOtherReq(String x) {};
}