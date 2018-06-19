import java.util.Scanner;

public class Cmd {

	public static void cmd() {
		System.out.print("?> ");
		Scanner s = new Scanner(System.in);
		String exp = s.nextLine();
		switch (exp) {
		case "exit":
			System.out.println("Program will now close");
			s.close();
			System.exit(0);
			break;
		default:
			System.out.println("Answer> " +Calc.doTheMath(exp));
			cmd();
		}
	}
}