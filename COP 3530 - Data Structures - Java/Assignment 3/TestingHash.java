/*
* This is a tester class for Customer and HashTable. It
* either shows the Assignment output or shows a menu that
* allows the user to choose from the following:
*	1) Display All Customers
*	2) Find Customer with Phone Number
*	3) Add Customer
*	4) Delete Customer
* Menu quits upon user entering 5 (Quit), otherwise, user
* will receive an error message.
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/29
*/

import java.util.LinkedList;
import java.util.Scanner;

class TestingHash {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		String returnCust = "";
		LinkedList<String> keyList = new LinkedList<>();

		//pupulating table with customer data
		hashTable.insert(new Customer("Lisa", "123 Main Street", "123456789"));
		keyList.add("123456789");
		hashTable.insert(new Customer("Alex", "6134 Dream Rd", "5148675309"));
		keyList.add("5148675309");
		hashTable.insert(new Customer("Gina", "55 Meow St", "481516234"));
		keyList.add("481516234");
		hashTable.insert(new Customer("Prof", "11 University Dr", "0123456780"));
		keyList.add("0123456780");
		hashTable.insert(new Customer("Jessie", "404 Silicone Blvd", "987654321"));
		keyList.add("987654321");

		//main menu
		//to display only the Main Menu, comment out the
		//Assignment Output Instructions code below
/*
		String name, address, phone = "";
		int menuChoice = 0;
		Scanner input = new Scanner(System.in);

		while(menuChoice != 5) {
			System.out.println("MAIN MENU");
			System.out.println("---------");
			System.out.println("1. Display All Customers");
			System.out.println("2. Find Customer with Phone Number");
			System.out.println("3. Add Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Quit");
			menuChoice = Integer.parseInt(input.nextLine());

			switch(menuChoice) {
				case 1: // Display All Customers
					System.out.println("\nAll Customers:");
					for(int i = 0; i < keyList.size(); i++) {
						returnCust = hashTable.getCustomer(keyList.get(i));
						System.out.println(returnCust);
					}
					System.out.println();
					break;
				case 2: // Find Customer with Phone Number
					phone = "";
					while((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
						System.out.print("\nEnter 9 digit phone number to look up: ");
						phone = input.nextLine();
						//verifying customer entered string
						if((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
							System.out.println("Please enter a valid phone number.");
						}
					}
					//checking if customer is in table
					if(hashTable.contains(phone)) { // is in table, printing info
						returnCust = hashTable.getCustomer(phone);
						System.out.println(returnCust);
					}
					else { // is not in table, printing error
						System.out.println("Customer with phone number " + phone + " is not in the table.");
					}
					System.out.println();
					break;
				case 3: // Add Customer
					System.out.print("\nEnter new customer name: ");
					name = input.nextLine();
					System.out.print("Enter new customer address: ");
					address = input.nextLine();
					phone = "";
					while((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
						System.out.print("Enter new customer 9 digit phone number: ");
						phone = input.nextLine();
						if((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
							System.out.println("Please enter a valid phone number.");
						}
					}
					Customer newCust = new Customer(name, address, phone);
					if(hashTable.contains(phone)) {
						System.out.println("Customer with " + phone + " is already in the table.\n");
					}
					else {
						keyList.add(phone);
						hashTable.insert(newCust);
						System.out.println(name + " has been added to the table.\n");
					}
					break;
				case 4: // Delete Customer
					phone = "";
					while((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
						System.out.print("\nEnter 9 digit phone number of customer you want to delete: ");
						phone = input.nextLine();
						//verifying customer entered string
						if((!phone.matches("[0-9]+")) || (phone.length() != 9)) {
							System.out.print("Please enter a valid phone number.");
						}
					}
					//checking if customer is in table
					if(hashTable.contains(phone)) { // is in table, deleting
						hashTable.delete(phone);
						keyList.remove(phone);
						System.out.println("Customer with phone number " + phone + " has been deleted from the table.");
					}
					else { // is not in table, printing error
						System.out.println("Customer with phone number " + phone + " is not in the table.");
					}
					System.out.println();
					break;
				case 5: // Quit
					break;
				default: // Error
					System.out.println("Please enter a valid choice.\n");
					break;
			}
		}
*/

		/*Assignment Output Instructions
		1. Build a hash table by inserting a phone number and the corresponding information.
		2. Search a phone number and fetch the information.
		3. Delete a phone number and related information.*/

		//to display only the Assignment Output Instructions,
		//comment out the Main Menu code above

		System.out.println("1) Building a hash table by inserting a phone number and the corresponding information...");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Displaying current customers in table:");
		for(int i = 0; i < keyList.size(); i++) {
			returnCust = hashTable.getCustomer(keyList.get(i));
			System.out.println(returnCust);
		}

		System.out.println();

		System.out.println("2) Searching a phone number and fetching the information...");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Displaying information for customer with phone number " + keyList.get(2) + ":");
		returnCust = hashTable.getCustomer(keyList.get(2));
		System.out.println(returnCust);

		System.out.println();

		System.out.println("3) Deleting customer with phone number " + keyList.get(1) + " and related information...");
		hashTable.delete(keyList.get(1));
		keyList.remove(1);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Displaying current customers in table:");
		for(int i = 0; i < keyList.size(); i++) {
			returnCust = hashTable.getCustomer(keyList.get(i));
			System.out.println(returnCust);
		}
	}
}