/**
 * This is a tester class for the Arithmetic class. This class
 * takes a string of expressions and passes them through the
 * Arithmetic class functions to determine balance, postfix
 * conversion via RPN, and solution.
 * 
 * @author Stephanie Gremillion
 * @version 17.0.2
 * @since 2022/09/01
 */

public class ArithmeticTester {
	public static void main(String[] arg) {
		String s[] = {"5 + ) * ( 2",
                     " 2 + ( - 3 * 5 ) ",
                     "(( 2 + 3 ) * 5 ) * 8 ",
                     "5 * 10 + ( 15 - 20 ) )  - 25",
                     " 5 + ( 5 * 10 + ( 15 - 20 )  - 25 ) * 9"};
		
		for (int i = 0; i < s.length; i++)
		{
			Arithmetic a = new Arithmetic(s[i]);
		    if (a.isBalance()) {
				System.out.println("Expression " + s[i] + " is balanced.");
				
				a.postfixExpression();
				System.out.println("The post fixed expression is: " + a.getPostfix());
				
				a.evaluateRPN();				
				a.printSolution();
								
				System.out.println();
		    }
		    else {
		    	System.out.println("Expression is not balanced.\n");
			}
		}
	}
}