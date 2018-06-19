public class Main {

	public static void main(String[] args) {
		System.out.println("RPN Calculator v1.0 (c)2018 Kamil Uszyński");
		System.out.println("Type expression in RPN and hit enter to calculate, type exit to quit program");
		
		/*
		 * Interface start
		 */
		
		core();

}
	public static void core() {
		try{ 
			
			/*
			 * Start of the CLI
			 */
			
			Cmd.cmd(); 
		}
		
			/*
			 * Restart of the CLI in case of exception
			 * (Failsafe)
			 */
		
		catch (Exception e) {
			System.out.println("");
			System.out.println("Invalid input!");
			System.out.println("Accepted format: Reverse Polish Notation");
			System.out.println("Accepted input: Numbers");
			System.out.println("Accepted operands: + - * / ^ !");
			System.out.println("");
			System.out.println("Type expression in RPN and hit enter to calculate, type exit to quit program");
			
			/*
			 * Auto restart of the failsafe
			 */
			
			core();
		}
	
	}
}