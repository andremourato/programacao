import static java.lang.System.*;
import java.util.Scanner;
import p2utils.*;

public class P132{
		
	public static void main(String[] args){
		
		ExpressionTree tree = new ExpressionTree();
		tree.printInfix();
		out.printf(" = %f\n", tree.eval());
	}
}

