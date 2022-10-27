/**
* The Administration class extend the Business class and adds attributes:
*     statsPrereq, language
* The toString() method in this class overrides the default method.
* The setLangUnreq() method in this class sets "language" variable to "Language Course(s) Unrequired"
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class Administration extends Business {
   // variables
   private String statsPrereq;
   private String language;
   
   // constructor
   public Administration(String name, double gPA, int aCT, int year, String stats, String lang) {
      super(name, gPA, aCT, year); // sends data back to Business, which sends back to Major
      statsPrereq = stats;
      language = lang;
   }
   
   // setter for statsPrereq
   public void setStatsPrereq(String stats) {
      statsPrereq = stats;
   }
   
   // setter for language
   public void setLanguage(String lang) {
      language = lang;
   }
   
   // getter for statsPrereq
   public String getStatsPrereq() {
      return statsPrereq;
   }
   
   // getter for language
   public String getLanguage() {
      return language;
   }
   
   // setting language unrequired
   public void setLangUnreq() {
      language = "Language Course(s) Unrequired";
   }
   
   // toString override
   public String toString() {
      return(super.getName() + " major requirements: " + statsPrereq + " and " + language);
   }
}