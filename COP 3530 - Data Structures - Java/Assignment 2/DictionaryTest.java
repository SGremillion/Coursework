/*
* This is a tester class for WordList, WordMeaningNode,
* and WordMeaning. It shows a menu that allows the user
* to list words (in ascending or descending order), add
* words, find words, delete words, and list deleted
* words. Menu quits upon user entering 6 (Quit).	
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

import java.util.Scanner;

public class DictionaryTest {
	public static void main(String[] args) {
		String[] words = { "Cup", "Library", "School" };
		String[] definitions = { "a container from which we drink",
								 "a collection of books",
								 "a place of learning"};
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int ascDesc = 0;
		String key;
      	
      	// creating tree
    	WordList dictionary = new WordList();
        for (int i = 0; i < words.length; i++)
        	dictionary.insert(new WordMeaning(words[i], definitions[i])); 

        /* To use the menu, uncomment the menu and comment out the
        	code under "Assignent 2 Output Instructions" below.*/
        /*
        // user menu
        while(choice != 6) {
        	System.out.println("DICTIONARY");
	        System.out.println("-----------");
	        System.out.println("1. List Words");
	        System.out.println("2. Add Word");
			System.out.println("3. Find Word");
	        System.out.println("4. Delete Word");
	        System.out.println("5. List Deleted Words");
	        System.out.println("6. Quit");

	        choice = Integer.parseInt(input.nextLine());
			System.out.println();

	        switch(choice) {
	        	case 1: // List Words
	        		ascDesc = 0;
	        		do {
		        		System.out.println("1. Ascending");
		        		System.out.println("2. Descending");
		        		ascDesc = Integer.parseInt(input.nextLine());
		        		switch(ascDesc) {
		        			case 1:
		        				dictionary.inOrder(dictionary.root);
		        				break;
		        			case 2:
		        				dictionary.inOrderDesc(dictionary.root);
		        				break;
		        			default:
		        				System.out.println("Please enter a valid choice.\n");
		        				break;
		        		} 
		        		System.out.println();
		        	} while(ascDesc != 1 && ascDesc != 2);
	        		break;
	        	case 2: // Add Word
	        		String tempWord = "";
	        		String tempDef = "";
	        		System.out.println("Enter the new word: ");
	        		tempWord = input.nextLine();
	        		System.out.println("Enter the definition: ");
	        		tempDef = input.nextLine();
	        		dictionary.insert(new WordMeaning(tempWord, tempDef));
	        		System.out.println();
	        		dictionary.inOrder(dictionary.root);
	        		System.out.println();
	        		break;
	        	case 3:
	        		String tempSearch = "";
	        		System.out.println("Enter the word for which to search: ");
	        		tempSearch = input.nextLine();
					System.out.println("The dictionary contains \"" + tempSearch + "\": " + dictionary.contains(dictionary.root, tempSearch) + "\n");
	        		break;
	        	case 4: // Delete Word
	        		String tempKey = "";
	        		System.out.println("Enter the word to delete: ");
	        		tempKey = input.nextLine();
	        		if(dictionary.contains(dictionary.root, tempKey)) {
						dictionary.deletedWords.add(tempKey);
						dictionary.root = dictionary.deleteNode(dictionary.root, tempKey);
					}
					else {
						System.out.println("The dictionary doesn't contain the word \"" + tempKey + "\".\n");
					}
	        		break;
	        	case 5: // List Deleted Words
	        		dictionary.printDeleted();
	        		break;
	        	case 6: // Quit
	        		break;
	        	default: // Invalid Choice
	        		System.out.println("Please enter a valid choice.\n");
	        		break;
	        }
        }*/

        /* To use the outupt instructions, uncomment the code below
        	and comment out the menu code above.*/

        /* Assignment 2 Ouput Instructions:
        	For the output, the program should produce two lists:
			- The current list of words and their meanings,  and
			- The list of the deleted words. Do not list the meanings.*/

			System.out.println("Current words in Dictionary:");
			dictionary.inOrder(dictionary.root);
			System.out.println();

			String word = "Cup";

			System.out.println("Deleting \"" + word + "\"...");
			if(dictionary.contains(dictionary.root, word)) {
				dictionary.deletedWords.add(word);
			}
			dictionary.root = dictionary.deleteNode(dictionary.root, word);

			System.out.println("\nPrinting deleted words:");
			dictionary.printDeleted();
			System.out.println();

			System.out.println("Current words in Dictionary:");
			dictionary.inOrder(dictionary.root);
			System.out.println();
	}		
}