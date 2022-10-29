/*
* This is an object class to hold words and their definitions.
*	getWord() - returns the stored word
*	getDefinition() - returns the stored definition
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

public class WordMeaning {
	private String word;
	private String definition;

	public WordMeaning(String word, String definition) {
		this.word = word;
		this.definition = definition;
	}

	public String getWord() {
		return this.word;
	}
	public String getDefinition() {
		return this.definition;
	}
}