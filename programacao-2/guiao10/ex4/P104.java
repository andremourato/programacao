import static java.lang.System.*;
import java.util.Scanner;
import p2utils.*;

public class P104 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(in);
		Stack<Double> stack = new Stack<Double>();
		while(read.hasNext()){
			String str = read.next();
			try{
				if(str.equals("+")){
					//First we remove the last 2 elements
					//from the stack (storing them in temp
					//variables)
					double a = stack.top();
					stack.pop();
					double b = stack.top();
					stack.pop();
					//Then we add the result to the stack
					stack.push(b+a);
				}else if(str.equals("-")){
					double a = stack.top();
					stack.pop();
					double b = stack.top();
					stack.pop();
					//It must be b-a not a-b
					//Because we must respect the
					//order in which the elements
					//were added to the stack
					stack.push(b-a);
				}else if(str.equals("*")){
					double a = stack.top();
					stack.pop();
					double b = stack.top();
					stack.pop();
					stack.push(b*a);
				}else if(str.equals("/")){
					double a = stack.top();
					stack.pop();
					double b = stack.top();
					stack.pop();
					stack.push(b/a);
				}else if(str.equals("%")){
					double a = stack.top();
					stack.pop();
					double b = stack.top();
					stack.pop();
					stack.push(b%a);
				}
				else{
					stack.push(Double.parseDouble(str));
				}
			}catch(NullPointerException e){
				out.println("ERROR: one operand missing!");
				exit(1);
			}catch(NumberFormatException e){
				out.println("ERROR: invalid operator!");
				exit(2);
			}
			out.printf("STACK: %s\n", stack.inString());
		}
	}
}

