/*
* This is an object class to create a Customer, holding
* their name, address, and phone number as well as a 
* hashKey for the hash table and a link to the next
* Customer.
* This class has the following functions:
*	hashKey() returns the Customer's hashKey
*	getCustomer() returns the Customer's information
*	getNext() returns the Customer the current one
*		points to
*	setNext(Customer) sets the Customer the current
*		one is pointing to
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/10/07
*/

public class Customer {
	private String name, address, phone;
	private int hashKey;
	private Customer next = null;

	//constructor
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.hashKey = Integer.parseInt(phone.substring(5, 8));
	}

	public int hashKey() { return hashKey; }
	public String getCustomer() {
		String temp = "" + this.name + " - " + this.address + " - " + this.phone;
		return temp;
	}
	public Customer getNext() { return next; }
	public void setNext(Customer cust) { this.next = cust; }
}