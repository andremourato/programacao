package p2utils;
import java.util.Scanner;
import static java.lang.System.*;

public class ExpressionTree {
	
	private static final Scanner in = new Scanner(System.in);
	private ExpressionTree left = null; //May be an operator or number
	private ExpressionTree right = null; //May be an operator or number
	private double number; //In case the tree is a number
	private String operator = null; //In case the tree is an operation
	
	public ExpressionTree(){
		if(in.hasNextDouble()){ //It's a leaf tree
			number = in.nextDouble();
		}
		else{ //It's an operator tree
			operator = in.next();
			if(!isOperator(operator)){ 
				err.println("ERROR: invalid prefix expression!");
				exit(1);
			}
			//Will wait for input and insert it has left child tree
			left = new ExpressionTree();
			//Will wait for input and insert it has right child tree
			right = new ExpressionTree();
		}
	}
	
	public void printInfix(){
		if(operator == null){
			out.print(number);
		}
		else{
			out.print("(");
			left.printInfix();
			out.print(operator);
			right.printInfix();
			out.print(")");
		}
	}
	
	public double eval(){
		if(operator != null){ //If it's an operator tree it calculates the result of it's children
			assert isOperator(operator);
			double result = 0;
			switch(operator){
				case "+":
					result = left.eval() + right.eval();
				break;
				
				case "-":
					result = left.eval() - right.eval();
				break;
				
				case "*":
					result = left.eval() * right.eval();
				break;
				
				default:
					result = left.eval() / right.eval();
				break;
			}
			
			return result;
		}
		else{ //If it's a leaf tree return it's value
			return number;
		}
		
	}
	
	public static boolean isOperator(String s){
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		return false;
	}
	
}

