/**
* This is the TVShowTester class that tests different sorting methods to sort  then print
* information stored in TVShow objects. It contains the following methods:
*
*      removeReturn(String): accepts a string, removes the return (\r) at the end of the 
*            string, and returns the string
*            
*      printShows(): prints all of the information for each TVShow object in the given array
*      
*      sortInsertion(TVShow array, int order, int category): takes an array of TVShow, sorts 
*            it via insertion sort in 1-ascending or 2-descending order, by 1-name or 2-season 
*            or 3-genre
*            
*	   sortSelection(TVShow array, int order, int category): takes an array of TVShow, sorts 
*         it via selection sort in 1-ascending or 2-descending order, by 1- year or 2- genre or 
*         3-male (lead last name)
*         
*	   sortMerge(TVShow array, int min, int max, int order, int category): takes an array of 
*         TVShow, sorts it via merge sort taking the min and max indexes from the given array, 
*         in 1-ascending or 2-descending order, by 1-network or 2-episodes or 3-female (lead 
*         last name)
*         
*	   mergeMerge(TVShow array, int min, int max, int order, int category): takes the divided 
*         arrays from sortMerge() and sorts them into a returned array
*         
*	   searchSequential(TVShow array, int x, int category): takes a TVShow array and searches 
*         it for TVShows that having matching information x, in 1-seasons or 2-episodes
*         
*	   searchBinary(TVShow array, String seeking, int min, int max, int category): takes TVShow 
*         array and finds if the information it is seeking is at the midpoint, then recursively 
*         sends back each half of the array to check if there are more matching cases in the first 
*         or second halves
*         
*	   lastName(String name): accepts a string with first and last name, finds the letter after the 
*         space (between the first and last name), and returns the substring of the last name
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/20
*/

import java.util.Scanner; // for use of Scanner
import java.io.IOException; // to throw exception with opening files
import java.io.File; // to be able to open a file
import java.util.ArrayList; // to use arrayLists and methods
import java.util.Arrays; // to use arrays and methods

public class TVShowTester {
   public static void main(String[] args) throws IOException {
      // variables
      Scanner in = new Scanner(new File("tv_shows.csv"));
      in.useDelimiter(",|\n"); // getting rid of commas and new lines
      TVShow[] shows = new TVShow[20];
      ArrayList<Integer> temp;
      
      // skipping first line full of labels
      in.nextLine();
      
      // reading file to create array objects
      for(int i = 0; i < 20; i++) {
         shows[i] = new TVShow(in.next(), Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next()), in.next(), in.next(), in.next(), removeReturn(in));
      }
      
      // printing pre-sort/manipulation table
      System.out.println("Initial List");
      System.out.println("-------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year Premiered");
      System.out.printf("%-20s", "Seasons");
      System.out.printf("%-20s", "Episodes");
      System.out.printf("%-20s", "Network");
      System.out.printf("%-20s", "Genre");
      System.out.printf("%-20s", "Male Lead");
      System.out.printf("%-20s", "Female Lead");
      System.out.println();
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nysewgmf"); }
      System.out.println();
      
      // printing Insertion Sort 1
      System.out.println("Insertion Sort 1: Name Ascending");
      System.out.println("--------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Male Lead");
      System.out.printf("%-20s\n", "Female Lead");
      sortInsertion(shows, 1, 1);
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nymf"); }
      //for(int i = 0; i < shows.length; i++) { shows[i].insSortOne(); }
      System.out.println();
      
      // printing Insertion Sort 2
      System.out.println("Insertion Sort 2: Seasons Descending");
      System.out.println("------------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s\n", "Seasons");
      sortInsertion(shows, 2, 2);
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nys"); }
      System.out.println();
      
      // printing Selection Sort 1
      System.out.println("Selection Sort 1: Year Ascending");
      System.out.println("--------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s\n", "Seasons");
      sortSelection(shows, 1, 1);
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nys"); }
      System.out.println();
      
      // printing Selection Sort 2
      System.out.println("Selection Sort 2: Genre Descending");
      System.out.println("----------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Episodes");
      System.out.printf("%-20s\n", "Genre");
      sortSelection(shows, 2, 2);
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("neg"); }
      System.out.println();
      
      // printing Merge Sort 1
      System.out.println("Merge Sort 1: Network Descending");
      System.out.println("--------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Seasons");
      System.out.printf("%-20s\n", "Network");
      sortMerge(shows, 0, shows.length - 1, 2, 1); //1 net, 2 epi
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nysw"); }
      System.out.println();
      
      // printing Merge Sort 2
      System.out.println("Merge Sort 2: Episodes Ascending");
      System.out.println("--------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Episodes");
      System.out.printf("%-20s\n", "Network");
      sortMerge(shows, 0, shows.length - 1, 1, 2);
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nyew"); }
      System.out.println();
      
      // printing Sequential Search 1
      System.out.println("Sequential Search 1: 2 Seasons");
      System.out.println("------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Seasons");
      System.out.printf("%-20s\n", "Network");
      temp = searchSequential(shows, 2, 1);
      for(int i = 0; i < temp.size(); i++) { shows[temp.get(i)].printInfo("nysw"); }
      System.out.println();
      
      // printing Sequential Search 2
      System.out.println("Sequential Search 2: 100+ Episodes");
      System.out.println("-----------------------------------");
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Seasons");
      System.out.printf("%-20s\n", "Episodes");
      temp = searchSequential(shows, 100, 2);
      for(int i = 0; i < temp.size(); i++) { shows[temp.get(i)].printInfo("nse"); }
      System.out.println();
      
      // printing Binary Search 1
      System.out.println("Binary Search 1: Shows Aired on CBS");
      System.out.println("-----------------------------------------------");
      System.out.println("Sorts by Network via Merge Sort Descending");
      System.out.println("-----------------------------------------------");
      temp = searchBinary(shows, "CBS", 0, shows.length - 1, 1);
      if(temp.isEmpty()) { System.out.println("No shows found from CBS Network."); }
      else {
         System.out.println(temp.size()  + " shows counted from CBS Network:");
         for(int i = 0; i < temp.size(); i++) { System.out.println(shows[temp.get(i)].getName()); }
      }
      System.out.println();
      
      // printing Binary Search 2
      System.out.println("Binary Search 2: Shows in the Fantasy Genre");
      System.out.println("-------------------------------------------------");
      System.out.println("Sorts by Genre via Selection Sort Descending");
      System.out.println("-------------------------------------------------");
      temp = searchBinary(shows, "Fantasy", 0, shows.length - 1, 2);
      if(temp.isEmpty()) { System.out.println("No shows in the Fantasy Genre."); }
      else{
         System.out.println(temp.size() + " shows counted in the Fantasy Genre:");
         for(int i = 0; i < temp.size(); i++) { System.out.println(shows[temp.get(i)].getName()); }
      }
      System.out.println();
      
      // printing Binary Search 3
      System.out.println("Binary Search 3: Shows in the Drama Genre");
      System.out.println("-------------------------------------------------");
      System.out.println("Sorts by Genre via Insertion Sort Descending");
      System.out.println("-------------------------------------------------");
      temp = searchBinary(shows, "Drama", 0, shows.length - 1, 2);
      if(temp.isEmpty()) { System.out.println("No shows in the Drama Genre."); }
      else{
         System.out.println(temp.size() + " shows counted in the Drama Genre:");
         for(int i = 0; i < temp.size(); i++) { System.out.println(shows[temp.get(i)].getName()); }
      }
      System.out.println();
      
      // printing Bonus 1
      System.out.println("Bonus 1: Male Lead Last Name Ascending via Selection Sort");
      System.out.println("---------------------------------------------------------");
      sortSelection(shows, 1, 3);
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Male Lead");
      System.out.printf("%-20s\n", "Female Lead");     
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nymf"); } 
      System.out.println();
      
      // printing Bonus 2
      System.out.println("Bonus 2: Female Lead Last Name Descending via Merge Sort");
      System.out.println("--------------------------------------------------------");
      sortMerge(shows, 0, shows.length - 1, 2, 3);
      System.out.printf("%-20s", "Name");
      System.out.printf("%-20s", "Year");
      System.out.printf("%-20s", "Male Lead");
      System.out.printf("%-20s\n", "Female Lead");     
      for(int i = 0; i < shows.length; i++) { shows[i].printInfo("nymf"); } 
      System.out.println();
      
      // close file
      in.close();
   } 
   /*~~~~~~~~~~~~~~~~~*/
   /*~~ END OF MAIN ~~*/
   /*~~~~~~~~~~~~~~~~~*/
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                      removeReturn()                               *
   * this method removes the return after the end of each row from the *
   * CSV file                                                          *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static String removeReturn(Scanner in) {
      String temp = in.next();
      temp = temp.replace("\r", "");
      return temp;
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                        printShows()                               *
   * this method prints all of the information for each show           *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static void printShows(TVShow[] shows) {
      for(int i = 0; i < (shows.length - 1); i++) {
         System.out.println(shows[i].toString());
      }
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                        sortInsertion()                            *
   * this method uses insertion sort to sort show category in ascending*
   * or descending order:                                              *
   *  order: 1 = ascending; 2 = descending                             *
   *  category: 1 = name; 2 = season; 3 = genre                        *
   *     hold considered show in temp                                  *
   *     while next index is bigger than previous, switch places       *
   *     place temp at next free index                                 *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static void sortInsertion(TVShow[] shows, int order, int category) {
      for(int i = 0; i < shows.length; i++) {
         TVShow next = shows[i];
         int index = i;
         
         if((order == 1) && (category == 1)) { // ascending, name
            while((index > 0) && ((shows[index - 1].getName().compareTo(next.getName()) > 0))) { // while name is bigger
               shows[index] = shows[index - 1]; // move smaller name closer to front
               index--;
            }
         }
         else if((order == 2) && (category == 1)) { // descending, name
            while((index > 0) && ((shows[index - 1].getName().compareTo(next.getName()) < 0))) { // while name is smaller
               shows[index] = shows[index - 1]; // move bigger name closer to front
               index--;
            }
         }
         else if((order == 1) && (category == 2)) { // ascending, season
            while((index > 0) && ((shows[index - 1].getSeasons() > next.getSeasons()))) { // while seasons is bigger
               shows[index] = shows[index - 1]; // move smaller name closer to front
               index--;
            }
         }
         else if((order == 2) && (category == 2)) { // descending, season
            while((index > 0) && ((shows[index - 1].getSeasons() < next.getSeasons()))) { // while seasons is smaller
               shows[index] = shows[index - 1]; // move bigger name closer to front
               index--;
            }
         }
         else if((order == 1) && (category == 3)) { // ascending, genre
            while((index > 0) && ((shows[index - 1].getGenre().compareTo(next.getGenre()) > 0))) { // while genre is bigger
               shows[index] = shows[index - 1]; // move smaller name closer to front
               index--;
            }
         }
         else if((order == 1) && (category == 3)) { // descending, genre
            while((index > 0) && ((shows[index - 1].getGenre().compareTo(next.getGenre()) < 0))) { // while genre is smaller
               shows[index] = shows[index - 1]; // move bigger name closer to front
               index--;
            }
         }
         shows[index] = next;
      }
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                          sortSelection()                          *
   * this method uses selection sort to sort show category in ascending*
   * or descending order:                                              *
   *  order: 1 = ascending; 2 = descending                             *
   *  category: 1 = year; 2 = genre; 3 = male                          *
   *     determine which one is larger, set that index to max          *
   *     store show at considered index in temp                        *
   *     set show at index i to show at max index                      *
   *     replace show at max index with show stored in temp            *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static void sortSelection(TVShow[] shows, int order, int category) {
      int i, ii, index;
      TVShow temp;
      
      for(i = (shows.length - 1); i >= 0; i--) {
         index = 0;
         for(ii = 0; ii <= i; ii++) {
            if((order == 1) && (category == 1)) { // ascending, year
               if(shows[ii].getYear() > shows[index].getYear()) { index = ii; }
            }
            else if((order == 2) && (category == 1)) { // descending, year
               if(shows[ii].getYear() < shows[index].getYear()) { index = ii; }
            }
            else if((order == 1) && (category == 2)) { // ascending, genre
               if(shows[ii].getGenre().compareTo(shows[index].getGenre()) > 0) { index = ii; }
            }
            else if((order ==2) && (category == 2)) { // descending, genre
               if(shows[ii].getGenre().compareTo(shows[index].getGenre()) < 0) { index = ii; }
            }
            else if((order == 1) && (category == 3)) { // ascending, male
               if(lastName(shows[ii].getMale()).compareTo(lastName(shows[index].getMale())) > 0) { index = ii; }
            }
            else if ((order == 2) && (category == 3)) { // descending, male
               if(lastName(shows[ii].getMale()).compareTo(lastName(shows[index].getMale())) < 0) { index = ii; }
            }
         }
         
         temp = shows[i]; // temporarily stores shows at index i
         shows[i] = shows[index]; // switches shows at index index to shows at index i
         shows[index] = temp; // sets shows at index to the temporary
      }
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                             sortMerge()                           *
   * this method uses merge sort to sort show category in ascending or *
   * descending order:                                                 *
   *  order: 1 = ascending; 2 = descending                             *
   *  category: 1 = network; 2 = episodes; 3 = female                  *
   *     determines mid point of array                                 *
   *     sorts array into two sections at mid: first and second half   *
   *     recursion: calls sortMerge() to sort                          *
   *     when finished sorting (min == max), calls mergeMerge helper   *
   *                                                                   *
   *                            mergeMerge  ()                         *
   * this is the helper method for sortMerge() that merges the first   *
   * and second halves of sorted arrays:                               *
   *     if the next first half index exceeds the middle number (too   *
   *        big), start adding the second half array                   *
   *     if the next second half index exceeds the max number (too     *
   *        big), start adding the first half array                    *
   *     if the next first half index considered is greater than the   *
   *        next second half index considered, add the first half      *
   *        index to the array                                         *
   *     otherwise, add the next second half index to the array        *
   *     set shows to temp array (which is sorted)                     *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static void sortMerge(TVShow[] shows, int min, int max, int order, int category) {
      if(min == max) { return; } // base case
      int mid = (min + max) / 2;
      
      sortMerge(shows, min, mid, order, category); // sorting first half
      sortMerge(shows, mid + 1, max, order, category); // sorting second half
      
      mergeMerge(shows, min, mid, max, order, category); // merging first and second half
   }
   
   // helper method to merge first and second half of network sorting
   public static void mergeMerge(TVShow[] shows, int min, int mid, int max, int order, int category) {
      TVShow[] temp = new TVShow[max - min + 1];
      int fNext = min; // first half next index
      int sNext = mid + 1; // second half next index
      int next = 0; // next shows index
      
      while((fNext <= mid) || (sNext <= max)) { 
         if(fNext > mid) { // if the first half is larger than the middle
            temp[next] = shows[sNext]; // start adding remaining second half to array
            sNext++;
         }
         else if(sNext > max) { // if the second half is larger than max
            temp[next] = shows[fNext]; // start adding remaining first half to array
            fNext++;
         }
         else if((order == 1) && (category == 1) && (shows[fNext].getNetwork().compareTo(shows[sNext].getNetwork()) < 0)) { // ascending, network
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else if((order == 2) && (category == 1) && (shows[fNext].getNetwork().compareTo(shows[sNext].getNetwork()) > 0)) { // descending, network
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else if((order == 1) && (category == 2) && (shows[fNext].getEpisodes() < shows[sNext].getEpisodes())) { // ascending, episodes
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else if((order == 2) && (category == 2) && (shows[fNext].getEpisodes() > shows[sNext].getEpisodes())) { // descending, episodes
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else if ((order == 1) && (category == 3) && (lastName(shows[fNext].getFemale()).compareTo(lastName(shows[sNext].getFemale())) < 0)) { // ascending, female
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else if ((order == 2) && (category == 3) && (lastName(shows[fNext].getFemale()).compareTo(lastName(shows[sNext].getFemale())) > 0)) { // descending, female
            temp[next] = shows[fNext]; // add next first to array
            fNext++;
         }
         else { // if next in first half is too big, add next in second half
            temp[next] = shows[sNext];
            sNext++;
         }
         next++;
      }
      
      for(int ii = min; ii <= max; ii++) { shows[ii] = temp[ii - min]; } // setting array to temp array
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                         searchSequential()                        *
   * this method uses sequential search to find number x in category:  *
   *  category: 1 = seasons; 2 = episodes                              *
   *     loops through each element in array                           *  
   *     if matches, adds to arrayList                                 *
   *     returns arrayList                                             *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static ArrayList<Integer> searchSequential(TVShow[] shows, int x, int category){
      ArrayList<Integer> temp = new ArrayList<>();
      for(int i = 0; i < shows.length; i++) {
         if(category == 1) { // seasons
            if(shows[i].getSeasons() == x) { temp.add(i); }
         }
         else { // episodes
            if(shows[i].getEpisodes() > x) { temp.add(i); }
         }
      }
      return temp;
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                          searchBinary()                           *
   * this method uses binary search to find all elements that match    *
   * category given min and max:                                       *
   *  category: 1 = network; 2 = genre                                 *
   *     determine mid point                                           *
   *     determine if category at mid point matches search             *
   *        if so, recursion: send first and second half back to       *
   *           searchBinary()                                          *
   *        if not, add -1 to array (indicates no return)              *
   *     determine if mid point is lower than category                 *
   *           if so, search second half of array                      *
   *     otherwise, search first half of array                         *
   *                                                                   *
   *     if nothing matches, return -1 (indicates no return)           *
   *     remove all -1: if no match, will return empty array, otherwise*
   *        return all indexes of matches                              *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static ArrayList<Integer> searchBinary(TVShow[] shows, String seeking, int min, int max, int category) {
      ArrayList<Integer> temp = new ArrayList<>(); // all matching elements' indexes
      ArrayList<Integer> recTemp = new ArrayList<>(); // matching elements in recursion calls
      
      if(seeking.compareTo("CBS") == 0) { sortMerge(shows, 0, shows.length - 1, 2, 1); } // merge sort
      if(seeking.compareTo("Fantasy") == 0) { sortSelection(shows, 2, 2); } // selection sort
      if(seeking.compareTo("Drama") == 0) { sortInsertion(shows, 3, 3); } // insertion sort
        
      if(min <= max) {
         int mid = (min + max) / 2;
                  
         if(((category == 1) && (seeking.compareTo(shows[mid].getNetwork()) == 0)) || 
           ((category == 2) && (seeking.compareTo(shows[mid].getGenre()) == 0))) { // if category at mid matches
            temp.add(mid);
            recTemp = searchBinary(shows, seeking, min, mid - 1, category); // search again in first half
            for(int i = 0; i < recTemp.size(); i++) { temp.add(recTemp.get(i)); } // add recursion results
            recTemp = searchBinary(shows, seeking, mid + 1, max, category); // search again in second half
            for(int i = 0; i < recTemp.size(); i++) { temp.add(recTemp.get(i)); } // add recursion results
         }
         else if(((category == 1) && (seeking.compareTo(shows[mid].getNetwork()) < 0)) || 
           ((category == 2) && (seeking.compareTo(shows[mid].getGenre()) < 0))) { // if category is less than mid
            return searchBinary(shows, seeking, mid + 1, max, category); // search second half
         }
         else { return searchBinary(shows, seeking, min, mid - 1, category); } // else search first half
      }
      
      if(temp.isEmpty()) { // returns if no matches
         temp.add(-1);
         return temp;
      }
      
      temp.removeAll(Arrays.asList(-1)); // removes all all unnecessary no matches
      return temp;
   }
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *                            lastName()                             *
   * this method finds last name (substring starting after space)      *
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static String lastName(String name) {
      return name.substring(name.lastIndexOf(" ") + 1);
   }
}