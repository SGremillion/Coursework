/**
* This is the TVShow class that holds instance variables for each TVShow object:
*     name, year premiered, seasons, episodes, network, genre, male lead, and 
*     female lead
* This class contains a constructor and getters for each instance variable. It
* also contains the following method:
*
*     printInfo(String options): accepts a string of letters corresponding to
*        the information that is requested to be gotten from the object:
*        n = name
*        y = year
*        s = seasons
*        e = episodes
*        w = network
*        g = genre
*        m = male lead
*        f = female lead
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/20
*/

public class TVShow {
   // variables
   public String name, network, genre, male, female;
   public int year, seasons, episodes;
   
   // constructor
   public TVShow(String na, int y, int s, int e, String ne, String g, String m, String f) {
      name = na;
      year = y;
      seasons = s;
      episodes = e;
      network = ne;
      genre = g;
      male = m;
      female = f;
   }
   
   // getters
   public String getName() { return name; }
   public int getYear() { return year; }
   public int getSeasons() { return seasons; }
   public int getEpisodes() { return episodes; }
   public String getNetwork() { return network; }
   public String getGenre() { return genre; }
   public String getMale() { return male; }
   public String getFemale() { return female; }
   
   // print info
   public void printInfo(String options) {
      if(options.contains("n")) { System.out.printf("%-20s", this.name); }
      if(options.contains("y")) { System.out.printf("%-20d", this.year); }
      if(options.contains("s")) { System.out.printf("%-20d", this.seasons); }
      if(options.contains("e")) { System.out.printf("%-20d", this.episodes); }
      if(options.contains("w")) { System.out.printf("%-20s", this.network); }
      if(options.contains("g")) { System.out.printf("%-20s", this.genre); }
      if(options.contains("m")) { System.out.printf("%-20s", this.male); }
      if(options.contains("f")) { System.out.printf("%-20s", this.female); }
      System.out.println();
   }
}