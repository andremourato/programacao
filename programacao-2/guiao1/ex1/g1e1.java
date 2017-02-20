import java.util.*;

public class g1e1 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Operation: ");
		String input = read.nextLine();
		double result = solveOperation(input);
		System.out.printf("Result = %.02f\n",result);
	}
	
	static double solveOperation(String input){
		Scanner sc = new Scanner(input);
		double a = sc.nextDouble();
		String operation = sc.next();
		double b = sc.nextDouble();
		if(operation.equals("+")) return a+b;
		else if(operation.equals("-")) return a-b;
		else if(operation.equals("*")) return a*b;
		else if(operation.equals("/")) return a/b;
		else{ 
			System.err.println("Operacao invalida!");
			System.exit(1);
		}
		return 0;
	}
}

