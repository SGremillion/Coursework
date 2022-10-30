/*
* This is an object class to create a hash table.
* This class has the following functions:
*	contains(String)
*		accepts a phone number which is turned into
*		a hashValue to search through the hash table
*	getCustomer(String)
*		accepts a phone number which is turned into
*		a hashValue to search through the hash table
*		and returns the Customer's information
*	insert(Customer)
*		accepts a Customer object; turns the Customer
*		phone into a hashValue and inserts it into
*		the hash table
*	delete(String)
*		accepts a phone number which is turned into
*		a hashValue to search through the has table,
*		find the matching Customer, and delete them
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	private final static int DEFAULT_SIZE = 101;
	Customer[] table;

	//constructor
	public HashTable() {
		table = new Customer[DEFAULT_SIZE];
		for(int i = 0; i < DEFAULT_SIZE; i++) {
			table[i] = null;
		}
	}

	//see if customer is in table
	public boolean contains(String phone) {
		int hashVal = Integer.parseInt(phone.substring(5, 8)) % DEFAULT_SIZE;
		boolean contain;
		if(table[hashVal] == null) {
			contain = false;
		}
		else {
			Customer temp = table[hashVal];
			int tempHashKey = temp.hashKey();
			while(temp != null && tempHashKey != Integer.parseInt(phone.substring(5, 8))) {
				temp = temp.getNext();
			}
			if(temp == null) { 
				contain = false;
			}
			else {
				contain = true;
			}
		}
		return contain;
	}

	//get customer data
	public String getCustomer(String phone) {
		int hashVal = Integer.parseInt(phone.substring(5, 8)) % DEFAULT_SIZE;
		String data = "";

		if(table[hashVal] == null) {
			for(int i = 0; i < 3; i++) { data = "null"; }
		}
		else {
			Customer temp = table[hashVal];
			int tempHashKey = temp.hashKey();
			while(temp != null && tempHashKey != Integer.parseInt(phone.substring(5, 8))) {
				temp = temp.getNext();
			}
			if(temp == null) { 
				for(int i = 0; i < 3; i++) { data = "null"; }
			}
			else {
				data = temp.getCustomer();
			}
		}
		return data;
	}

	//insert new customer into table
	public void insert(Customer cust) {
		int hashVal = cust.hashKey() % DEFAULT_SIZE;
		if(table[hashVal] == null) {
			table[hashVal] = cust;
		}
		else {
			Customer temp = table[hashVal];
			int tempHashKey = temp.hashKey();
			while(temp.getNext() != null && tempHashKey != cust.hashKey()) {
				temp = temp.getNext();
			}
			if(tempHashKey != cust.hashKey()) {
				temp.setNext(cust);
			}
		}
	}

	//delete customer from table
	public void delete(String phone) {
		int hashVal = Integer.parseInt(phone.substring(5, 8)) % DEFAULT_SIZE;
		if(table[hashVal] != null) {
			Customer prevCust = null;
			Customer temp = table[hashVal];
			int tempHashKey = temp.hashKey();
			while(temp.getNext() != null && tempHashKey != Integer.parseInt(phone.substring(5, 8))){
				prevCust = temp;
				temp = temp.getNext();
			}
			if(tempHashKey == Integer.parseInt(phone.substring(5, 8))) {
				if(prevCust == null) {
					table[hashVal] = temp.getNext();
				}
				else {
					prevCust.setNext(temp.getNext());
				}
			}
		}
	}
}