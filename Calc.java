import java.util.Stack;

public class Calc {

	static double doTheMath(String in) {
		
		/* Reverse Polish Notation Calculator, Stack Implementation 
		 * 
		 * Decalration of stack, final answer variable, and preparation of 
		 * input string for calculations.
		 */
		
		Stack<Double> val = new Stack<>();
		in = in.trim();
		String[] parts = in.split("\\s+");
		double ans = 0;
		
		/* 
		 * Calculations loop
		 */
		
		for (String part : parts) {
			
			/*
			 * Checking if current substring is an operand.
			 * If yes, it is added to the top of the stack.
			 * If not, it triggers calculation call.
			 */
			
			if (num(part)) {				
				val.add(Double.parseDouble(part));				
			} else {
				
				/*
				 * In this implementation i use only one "register"
				 * an variable to store last operand before the 
				 * operator. Second operand is taken straight from the stack.
				 * 
				 * Order of operation is maintained as last operand is stored
				 * in "register" and used AFTER new value is popped from stack
				 */
				
				double reg = val.pop();
				switch (part) {
					case "+":
						ans = val.pop() + reg;
						break;
					case "-":
						ans = val.pop() - reg;
						break;
					case "*":
						ans = val.pop() * reg;
						break;
					case "/":
						ans = val.pop() / reg;
						break;
					case "^":
						ans = Math.pow(val.pop(), reg);
						break;
					case "!":
						
						/* 
						 * Checking if factorial base number 
						 * is an integer. If yes it continues
						 * calculation.
						 * 
						 * Also factorial requires only one
						 * operand so there's no popping of
						 * the second value from the stack
						 * (as it might be the only operand
						 * and we might cause exception)
						 */
						
						if (reg == Math.floor(reg)) {
							ans = factorial(reg);
						} else {
							
							/* 
							 * Otherwise it returns 0 as an equivalent for null
							 * and a message as factorial can be calculated only 
							 * from integers.
							 */
							
							System.out.println("ERROR: Base for factorial must be an integer!");
							ans = 0;
						}
						break;
				}
				
				/*
				 * Adding temporary value (result of the 
				 * last operation) to the top of the stack.
				 * It will be used in the next operation
				 * (until current block will be finished
				 * and there will be no more operators)
				 * After that algorithm will start adding
				 * next operands until it finds another 
				 * operator.
				 * Cycle will continue until last operator
				 * is used.
				 */
				
				val.add(ans);
			}
		}
		
		/*
		 * After last operator is used,
		 * function returns final answer.
		 */
		
		return ans;

	}
	
	/* 
	 * Below function is used for differentiating
	 * between operands and operators.
	 * if not on this list current element will
	 * be treated as an operand.
	 * If it is not an operator and not a numeric 
	 * operand it will raise NumberFormatException
	 * that is handled in Main.core().
	 * Main.core() is used as an failsafe for 
	 * restarting command line interface in case of
	 * an exception. Even though Cmd restarts itself
	 * after every calculation, in case of exception
	 * it won't do it so core() function is used for
	 * handling exceptions and restarting interface
	 * if one occurs.  
	 */

	private static boolean num(String s) {
		return !(s.equals("+") || 
				 s.equals("-") || 
				 s.equals("*") || 
				 s.equals("/") || 
				 s.equals("^") || 
				 s.equals("!")
				);
	}
	
	/*
	 * Most straightforward implementation of
	 * factorial function. It starts from 1 
	 * and goes up multiplying itself by each
	 * integer up to factorial base number.
	 */

	private static double factorial(double in) {
		double fac = 1;
		for (int i = 1; i < in + 1; i++) {
			fac = fac * i;
		}
		return fac;
	}
}
