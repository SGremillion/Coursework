/**
* The MajorTester class creates testing objects for the Major class and all
*     of the classes that extend Major:
*     English (Art), Math (Computer Science), Business (Management, Administration)
* The main method creates and prints an array of Major objects.
* The updateMajors() class updates the information for each subclass.
* The main method then prints again the Major objects with the new information.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/06
*/

public class MajorTester {
   public static void main(String[] args) {
      // creating objects in array
      Major[] majors = new Major[8];
      majors[0] = new Major("TBD", 2.50, 23);
      majors[1] = new English("English", 2.75, 30, 32);
      majors[2] = new Math("Math", 3.00, 25, 35);
      majors[3] = new Business("Business", 2.75, 25, 1);
      majors[4] = new Art("Art", 2.50, 25, 25, "Art 101", "Portfolio");
      majors[5] = new ComputerScience("Computer Science", 3.00, 30, 32, "Advisor Permission Required", "Math 110");
      majors[6] = new Management("Business Management", 2.75, 27, 2, "English 101");
      majors[7] = new Administration("Business Administration", 3.00, 30, 2, "Stats 110", "French 101 & 102");
      
      // setting prereq
      majors[0].setPrereq();
      majors[1].setPrereq();
      majors[2].setPrereq();
      majors[3].setPrereq();
      majors[4].setPrereq();
      majors[5].setPrereq();
      majors[6].setPrereq();
      majors[7].setPrereq();
            
      // printing majors information
      for(int ii = 0; ii < 2; ii++) { // prints information twice, second time updated with new information
         for(int i = 0; i < 8; i++) {
            System.out.println("Major: " + majors[i].getName());
            System.out.printf("Minimum GPA: %.2f\n", majors[i].getGPA());
            System.out.println("Minimum ACT: " + majors[i].getACT());
            System.out.println("Core Prerequisite: " + majors[i].getPrereq());
            switch(i) {
               case 1: // prints English information
                  System.out.println("Minimum English ACT: " + majors[i].getEngAct());
                  System.out.println(majors[i].toString());
                  break;
               case 2: // prints Math information
                  System.out.println("Minimum Math ACT: " + majors[i].getMathAct());
                  System.out.println(majors[i].toString());
                  break;
               case 3: // prints Business information
                  System.out.println("Class Year Requirement: " + majors[i].getYear());
                  System.out.println(majors[i].toString());
                  break;
               case 4: // prints Art information
                  System.out.println("Minimum English ACT: " + majors[i].getEngAct());
                  System.out.println("Other Requirements: " + majors[i].getOtherReq());
                  System.out.println(majors[i].toString());
                  break;
               case 5: // prints ComputerScience information
                  System.out.println("Minimum Math ACT: " + majors[i].getMathAct());
                  System.out.println("Requirements: " + majors[i].getPermission());
                  System.out.println("Math Prerequisite: " + majors[i].getMathPrereq());
                  System.out.println(majors[i].toString());
                  break;
               case 6: // prints Management information
                  System.out.println("Class Year Requirement: " + majors[i].getYear());
                  System.out.println("English Prerequisite: " + majors[i].getEngPrereq());
                  System.out.println(majors[i].toString());
                  break;
               case 7: // prints Administration information
                  System.out.println("Class Year Requirement: " + majors[i].getYear());
                  System.out.println("Statistics Prerequisite: " + majors[i].getStatsPrereq());
                  System.out.println("Language Requirement: " + majors[i].getLanguage());
                  System.out.println(majors[i].toString());
                  break;
               default:
                  break;
            }
            System.out.println(); // empty line
         }
         
         if(ii != 0) { 
            System.out.println(majors[1].equals(majors[5].getName(), majors[5].getGPA(), majors[5].getACT())); // prints comparison of English and Computer Science
            System.out.println(); // empty line
         }
         
         if(ii == 0) {
            System.out.println(majors[5].equals(majors[5].getName(), majors[5].getGPA(), majors[5].getACT())); // prints comparison of Computer Science and Computer Science
            System.out.println(); // empty line
            System.out.println("------------------------------");
            System.out.println("Updating majors information...");
            System.out.println("------------------------------");
            System.out.println(); // empty line
            updateMajors(majors); // updates the majors with new information
         }
      }
   }
   
   // using the setters to update major information
   public static void updateMajors(Major[] majors) {
      // updating majors information
      majors[0].setName("Undeclared"); // setting new Major name
      
      majors[1].setGPA(3.00); // setting new English GPA requirement
      majors[1].setACT(27); // setting new English ACT requirement
      majors[1].setEngAct(30); // setting new English eng ACT requirement
      
      majors[2].setGPA(2.75); // setting new Math GPA requirement
      majors[2].setACT(30); // setting new Math ACT requirement
      majors[2].setMathAct(30); // setting new Math math ACT requirement
      
      majors[3].setGPA(2.50); // setting new Business GPA requirement
      majors[3].setACT(27); // setting new Business ACT requirement
      majors[3].setYear(2); // setting new Business year requirement
      
      majors[4].setGPA(2.75); // setting new Art GPA requirement
      majors[4].setACT(27); // setting new Art ACT requirement
      majors[4].setEngAct(32); // setting new Art eng ACT requirement
      majors[4].setOtherReq("E-Portfolio"); // setting new Art other requirement
      
      majors[5].setGPA(3.75); // setting new Computer Science GPA requirement
      majors[5].setACT(32); // setting new Computer Science ACT requirement
      majors[5].setMathAct(30); // setting new Computer Science math ACT requirement
      majors[5].setMathPrereq("Math 220"); // setting new Computer Science math prerequisite
      majors[5].setPermUnreq(); // setting Computer Science advisor permission unrequired
      
      majors[6].setName("Management"); // setting new Management name
      majors[6].setGPA(3.00); // setting new Management GPA requirement
      majors[6].setACT(30); // setting new Management ACT requirement
      majors[6].setCorePrereq("Speech 120"); // setting new Management core prerequisite;
      majors[6].setEngPrereq("English 210"); // setting new Managagement english prerequisite
      majors[6].setYear(3); // setting new Management year requirement
      
      majors[7].setName("Administration"); // setting new Administration name
      majors[7].setGPA(3.25); // setting new Administration GPA requirement
      majors[7].setACT(32); // setting new Administration ACT requirement
      majors[7].setCorePrereq("Speech 120"); // setting new Administration core prerequisite
      majors[7].setStatsPrereq("Stats 210"); // setting new Administration stats prerequisite
      majors[7].setLangUnreq(); // setting Administration language requirement unrequired
      majors[7].setYear(3); // setting new Administration year requirement
   }
}