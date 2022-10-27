/**
* This is the Dinosaur interface which is implemented by Carnivore and
*     Herbivore.
* 
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/07/14
*/

public interface Dinosaur {   
   // base class method headers
   public String getTime();
   public void setTime( String time );
   public String getLocation();
   public void setLocation( String location );
   public double getSize();
   public void setSize( double size);
   public int getLegs();
   public void setLegs(int legs );
   public String getTeeth();
   public void setTeeth( String teeth );
   public int getWeight();
   public void setWeight( int weight );
   public String getFood();
   public void setFood( String food );
   public String getDiet(); 
   
   // extended class method headers
   public String getType();
   public String getDescription();
   
   // subclass class method headers
   public String getName();
   public String getMeaning();
   public String getPerson();
}