/*
* This is an object class to to create nodes for the
* binary search tree. The nodes hold the location
* of their left and right children as well as a
* WordMeaning object.
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

public class WordMeaningNode {    
	WordMeaning word;
	WordMeaningNode left, right; 

	// constructor	
	public WordMeaningNode(WordMeaning word) { 
		this.word = word; 
		left = null; 
		right = null; 
	}
}