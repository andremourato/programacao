import static java.lang.System.*;
import p2utils.*;

public class P101 {
	
	public static void main (String[] args) {
		if(args.length != 1){
			out.println("Usage: java -ea P101 <text>");
			exit(1);
		}
		
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new Queue<Character>();
		
		/*First we insert each character of the text in both
		the stack and the queue*/
		for(int i = 0; i < args[0].length(); i++){
			char c = args[0].charAt(i);
			//We must ignore blank spaces
			if(c != ' '){
				stack.push(c);
				queue.in(c);
			}
		}
		/*Then remove each cahracter from both of them
		 * and compare them*/
		String result = "";
		do{
			if(stack.top().compareTo(queue.peek()) != 0)
				result = "not ";
			stack.pop();
			queue.out();
		}while(!stack.isEmpty());
		out.printf("Text \"%s\" is %sa palindrome!\n", args[0], result);
	}
}

