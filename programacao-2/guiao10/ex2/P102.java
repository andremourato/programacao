import static java.lang.System.*;
import p2utils.*;

public class P102 {
	
	public static void main (String[] args) {
		if(args.length != 1){
			out.println("Usage: java -ea P102 <n>");
			exit(1);
		}
		Stack<Integer> TA = new Stack<Integer>();
		int n = Integer.parseInt(args[0]);
		//Placing 'n' discs in the first stack
		for(int i = n; i > 0; i--){
			TA.push(i);
		}
		
		HanoiTowers hanoi = new HanoiTowers(n, TA);
		hanoi.printInfo();
		hanoi.start(n);
		out.printf("Number of moves: %d\n", hanoi.move());
	}
}
