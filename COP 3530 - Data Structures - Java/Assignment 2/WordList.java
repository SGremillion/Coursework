/*
* This is an object class to create a binary search tree.
* This class has the following functions:
*	insert(WordMeaning)
*		recursively inserts a new node by checking the
*		new node's letter against the nodes' letters
*		that are already in the tree
*	contains(WordMeaning, String)
*		recursively searches the tree for the String
*		key by checking the String against each node's
*		word already in the tree
*	inOrder(WordMeaningNode)
*		recursively prints out each node in ascending
*		order
*	inOrderDesc(WordMeaningNode)
*		recursively prints out each node in descending
*		order
*	deleteNode(WordMeaningNode, String)
*		recursively findes node to delete and brings
*		the nodes below up to replace the deleted node
*	getMinimumKey(WordMeaningNode)
*		helper for deleteNode() to find the lowest node
*		in the current branch to bring up		
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

import java.util.LinkedList;

public class WordList {
	WordMeaningNode root;
	String s;
	static LinkedList<String> deletedWords;

	// constructor
	public WordList() {
		this.root = null;
		this.s = " ";
		this.deletedWords = new LinkedList<>();
	}

	// for inserting new nodes
	public void insert(WordMeaning word) { 
		root = insertNode(root, word); 
	}
	public WordMeaningNode insertNode(WordMeaningNode root, WordMeaning word) {
		if(root == null) { // base case, this is where new node goes
			root = new WordMeaningNode(word);
			return root;
		}

		// new node is smaller so it goes checks to the left
		if(root.word.getWord().compareToIgnoreCase(word.getWord()) > 0) {
			root.left = insertNode(root.left, word);
		}
		// new node is bigger so it checks to the right
		else if(root.word.getWord().compareToIgnoreCase(word.getWord()) < 0) {
			root.right = insertNode(root.right, word);
		}

		return root;
	}

	// for finding words in tree
	public boolean contains(WordMeaningNode root, String key) {
		if(root == null) { // reached end of tree with no match
			return false;
		}

		boolean cont = false;
		// word is at current node
		if(root.word.getWord().compareToIgnoreCase(key) == 0) {
			return true;
		}
		// word is bigger so it checks to the right
		else if(root.word.getWord().compareToIgnoreCase(key) < 0) {
			cont = contains(root.right, key);
		}
		// word is smaller so it checks to the left
		else if(root.word.getWord().compareToIgnoreCase(key) > 0) {
			cont = contains(root.left, key);
		}
		return cont;
	}

	// for traversing in ascending order
	public void inOrder(WordMeaningNode node)
	{
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.word.getWord() + " - " + node.word.getDefinition());
			inOrder(node.right);
		}
	}

	// for traversing in descending order   
	public void inOrderDesc(WordMeaningNode node) {
		if(node != null) {
			inOrderDesc(node.right);
			System.out.println(node.word.getWord() + " - " + node.word.getDefinition());
			inOrderDesc(node.left);
		}
	}

	// for removing words from tree
	public static WordMeaningNode deleteNode(WordMeaningNode root, String key) {
		if(root == null) { // base case
			return null;
		}
		// finding the right node to delete
		 // key is bigger so it checks to the right
		else if(root.word.getWord().compareToIgnoreCase(key) < 0) {
			root.right = deleteNode(root.right, key);
		}
		 // key is smaller so it checks to the left
		else if(root.word.getWord().compareToIgnoreCase(key) > 0) {
			root.left = deleteNode(root.left, key);
		}
		else {
			// dealing with deleted node's children
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}

			root.word = getMinimumKey(root.right);
			root.right = deleteNode(root.right, root.word.getWord());
		}
		return root;
	}

	// for printing out deleted words
	public static void printDeleted() {
		if(deletedWords.size() != 0) {
    		for(int i = 0; i < deletedWords.size(); i++) {
    			if(i != deletedWords.size()-1) { // no comma after last word
    				System.out.println(deletedWords.get(i) + ", ");
    			}
    			else {
    				System.out.print(deletedWords.get(i));
    			}
    		}
    		System.out.println();
    	}
    	else {
    		System.out.println("No words have been deleted.\n");
    	}
	}

	// finding smallest word
	public static WordMeaning getMinimumKey(WordMeaningNode node) {
		WordMeaning word = node.word;
		while(node.left != null) {
			word = node.left.word;
			node = node.left;
		}
		return word;
	}
}