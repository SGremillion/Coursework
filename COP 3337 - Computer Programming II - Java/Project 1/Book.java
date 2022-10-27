/**
* The class Book creates a book object with the ability to change and display
* the following attributes:
*        title, author, genre, edition, pages read, rating
* 
* @author Stephanie Gremillion
* @ version 17.0.2
* @since 2022/06/24
*/

public class Book {
   
   // set variables
   private String title, author, genre, edition;
   private int pagesRead, rating;
   
   // constructor
   public Book(String conTitle, String conAuthor, String conGenre, 
               String conEdition, int conPages, int conRating) {
   
      title = conTitle;
      author = conAuthor;
      genre = conGenre;
      edition = conEdition;
      pagesRead = conPages;
      rating = ((conRating * 100) / 10);
   }
   
   // setting the attributes
   public void setTitle(String titl) { title = titl; } // setting the title
   public void setAuthor(String auth) { author = auth; } // setting the author
   public void setGenre(String genr) { genre = genr; } // setting the genre
   public void setEdition(String editn) { edition = editn; } // setting the edition
   public void setPages(int pages) { pagesRead = pages; } // setting the pagesRead
   public void setRating(int rate) { rating = ((rate * 100) / 10); } // setting the rating
   
   // manipulating pages and rating
   public void changePages(int changePage) { pagesRead += changePage; } // changes the pages
   public void changeRating(int changeRate) { rating = ((changeRate * 100) / 10); } // changes the rating
   
   // getting the attributes
   public String getTitle() { return title; } // getting the title
   public String getAuthor() { return author; } // getting the author
   public String getGenre() { return genre; } // getting the genre
   public String getEdition() { return edition; } // getting the edition
   public int getPages() { return pagesRead; } // getting the pages
   public int getRating() { return rating; } // getting the rating
   
}