import static java.lang.System.*;

public class AllDivisors {
	
	public static void main (String[] args) {
		
		if(args.length != 1){
			out.println("Usage: java P2 <number>\n");
			exit(1);
		}
		int n = Integer.parseInt(args[0]);
		out.println();
		printDiv(n, 0);
		
	}
	
	static void printDiv(int n, int indentation){
		
		for(int ind = 0; ind < indentation; ind++) //indenta os números
			out.print("	");
			
		out.println(n);
		
		for(int i = n/2; i > 1; i--){	
			if(n % i == 0){
				printDiv(i, indentation+1);
			}
		}
	}
}

