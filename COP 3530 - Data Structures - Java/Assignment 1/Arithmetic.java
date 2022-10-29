/**
 * This Arithmetic class converts regular mathematical expression 
 * into postfix RPN and solves them.
 * 
 * Arithmetic(String) is the constructor and accepts an expression in 
 *    the form of a string. It evaluates the string and places each 
 *    element that isn't a space into an ArrayList for easier 
 *    conversion.
 * 
 * isBalance() compares the equality of open and close parentheses in
 *    the ArrayList to determine if the equation is balanced (has equal
 *    open and close parentheses).
 *    
 * postfixExpression() converts the balanced expression into postfix RPN.
 *    It evaluates each item in the expression and does the following:
 *       If expression is a number, pushes number to the ArrayList.
 *       If expression is (, pushing ( to the stack.
 *       If expression is ), pops from stack to ArrayList until ( is
 *          encountered.
 *       If expression is an operator, pops from the stack to ArrayList
 *          until an operator of a higher precedence is on the stack.
 *          Then, pushes the expression to the stack.
 *          
 * precedence(String) determines which characters have higher precedence:
 *    ( is lowest at 0
 *    + or - are next at 1
 *    everything else *,/, or % are highest at 2
 *    
 * getPostfix() returns the returns the postfix expression as a String.
 * 
 * evaluateRPN() takes the postfix expression and calculates:
 *    If expression is number, its pushed onto numStack.
 *    Otherwise, the operator pops the two topmost numbers from
 *       numStack and calculates them. The resulting value is
 *       pushed back onto numStack.
 *    Determines if - is supposed to be negative sign by checking
 *       if it is between two other operators.
 *       
 * printSolution() prints the end result of the calculation.
 * 
 * @author Stephanie Gremillion
 * @version 17.0.2
 * @since 2022/09/01
 */

import java.util.Stack;
import java.util.ArrayList;

public class Arithmetic {
	// variables
	private ArrayList<String> expression;
	private ArrayList<String> postExpression;
	private Stack<String> stack = new Stack<>();
	private Stack<Integer> numStack = new Stack<>();
	private int solution;
	
	// constructor, turns string into ArrayList
	public Arithmetic(String s) {
		expression = new ArrayList<>();
		for(int i = 0; i <= s.length() - 1; i++) {
			
			// if is number, check if multi digit number and add to expression
			if(Character.isDigit(s.charAt(i))) {
				String temp = "";
				
				// checking if multi digit number
				if((i+1 < s.length()) && Character.isDigit(s.charAt(i+1))) {
					temp += s.charAt(i);
					temp += s.charAt(i + 1);
					expression.add(temp);
					i ++;
					continue;
				}
				else {
					// if single digit number, add to expression
					temp += s.charAt(i);
					expression.add(temp);
				}
			}
			// if operator, add to expression
			else if(s.charAt(i) == '*' || s.charAt(i) == '/' || 
					s.charAt(i) == '+' || s.charAt(i) == '-' ||
					s.charAt(i) == '(' || s.charAt(i) == ')' ||
					s.charAt(i) == '%') {
				expression.add(Character.toString(s.charAt(i)));
			}
		}
	}
	
	// checking expression for parentheses balance
	public boolean isBalance() {
		stack = new Stack<>();
		
		for(int i = 0; i < expression.size(); i++) {
			if(expression.get(i).compareTo("(") == 0) {
				stack.push(expression.get(i));
			}
			else if((expression.get(i).compareTo(")") == 0) && (!stack.empty())) {
				stack.pop();
			}
			else if((expression.get(i).compareTo(")") == 0) && (stack.empty())) {
				return false;
			}
		}
		
		return stack.empty();
	}
	
	// convert to postfix expression
	public void postfixExpression() {
		stack = new Stack<>();
		postExpression = new ArrayList<>();
		int i = 0;
		
		while(i < expression.size()) {
			
			// if the next expression is a number, push to output
			if(expression.get(i).matches("[0-9]+")) {
				postExpression.add(expression.get(i));
			}
			
			// if the next expression is open (, push it to the stack
			else if(expression.get(i).compareTo("(") == 0) {
				stack.push(expression.get(i));
			}
			
			// if the next expression is close ), pop from stack to output until we find the next open (
			else if(expression.get(i).compareTo(")") == 0) {
				while(!stack.isEmpty() && stack.peek().compareTo("(") != 0) {
					postExpression.add(stack.pop());
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
			
			// otherwise, pop from stack to output until stack has higher precedence operator
			else {
				while(!stack.isEmpty() && (precedence(stack.peek()) >= precedence(expression.get(i)))) {
					postExpression.add(stack.pop());
				}
				stack.push(expression.get(i));
			}
				
			i++;
		}
		
		// place remaining chars from stack into output
		while(!stack.empty()) {
			if(stack.peek().compareTo("(") != 0) {
				postExpression.add(stack.pop());
			}
		}
	}
	
	// comparing arithmetic chars
	public int precedence(String x) {
		switch(x) {
			case "(":
				return 0;
			case "+":
			case "-":
				return 1;
			default:
				return 2;
		}
	}
	
	// returning postfix expression
	public String getPostfix() {
		String temp = "";
		for(int i = 0; i < postExpression.size(); i++) {
			temp += postExpression.get(i);
		}
		return temp;
	}
	
	// solving the postfix expression
	public void evaluateRPN() {
		numStack = new Stack<>();
		int t1;
		int t2;
		int val; 
		String operator;
		
		for(int i = 0; i < postExpression.size(); i++) {
			
			// if number, push to numStack
			if((postExpression.get(i).matches("[0-9]+")) || postExpression.get(i).matches("-[0-9]+")) {
				numStack.push(Integer.parseInt(postExpression.get(i)));
			}
			
			// otherwise, if its an operator...
			else {
				operator = postExpression.get(i);
				switch(operator) {
				
					// adds top two numbers from numStack and pushes back result
					case "+":
						t1 = numStack.pop();
						t2 = numStack.pop();
						val = t1 + t2;
						numStack.push(val);
						break;
						
					// subtracts top two numbers from numStack and pushes back result
					case "-":
						// accounting for negative by checking if - sign is between two other operators
						if((i > 1) && (postExpression.get(i-1).compareTo("*") == 0 ||
							postExpression.get(i-1).compareTo("/") == 0 || postExpression.get(i-1).compareTo("-") == 0 ||
							postExpression.get(i-1).compareTo("+") == 0) && (postExpression.get(i+1).compareTo("*") == 0 ||
							postExpression.get(i+1).compareTo("/") == 0 || postExpression.get(i+1).compareTo("-") == 0 ||
							postExpression.get(i+1).compareTo("+") == 0)) {
							t1 = numStack.pop();
							t1 *= -1;
							numStack.push(t1);
						}
						else {
							t1 = numStack.pop();
							t2 = numStack.pop();
							val = t2 - t1;
							numStack.push(val);
						}
						break;
						
					// multiplies top two numbers from numStack and pushes back result
					case "*":
						t1 = numStack.pop();
						t2 = numStack.pop();
						val = t1 * t2;
						numStack.push(val);
						break;
						
					// divides top two numbers from numStack and pushes back result
					case "/":
						t1 = numStack.pop();
						t2 = numStack.pop();
						val = t2 / t1;
						numStack.push(val);
						break;
					// returns remainder of top two numbers from numStack and pushes back result
					case "%":
						t1 = numStack.pop();
						t2 = numStack.pop();
						val = t2 % t1;
						numStack.push(val);
						break;
					default:
						break;
				}
			}
		}
		// the last number in numStack is the solution to the problem
		solution = numStack.pop();
	} 
	
	// print solution
	public void printSolution() {
		System.out.println("The answer to the RPN expression " + getPostfix() + " is " + solution + ".");
	} 
}
