package p2utils;
import static java.lang.System.*;


public class HanoiTowers<E> {
	
	public HanoiTowers(int n, Stack<E> TA){
		this.TA = TA;
	}
	
	private int move = 0;
	private Stack<E> TA;
	private Stack<E> TB = new Stack<E>();
	private Stack<E> TC = new Stack<E>();
	
	public void printInfo(){
		//Prints the elements in the stacks
		out.printf("After %d moves: \n", move);
		out.println("TA: " + TA.toString());
		out.println("TB: " + TC.toString());
		out.println("TC: " + TB.toString() + "\n");
	}
	
	public void start(int n){
		moveDiscs(n, TA, TC, TB);
	}
	
	private void moveDiscs(int n, Stack<E> origem, Stack<E> destino, Stack<E> auxiliar){
		assert n >= 0;
		if (n > 0){
			//Moves 
			moveDiscs(n-1, origem, auxiliar, destino);
			//out.println("Move disc "+n+" da torre "+origem+" para a torre "+destino);
			
			//Moves the disc on one stack to the other ('moverUmDisco' nos pps)
			moveOneDisc(origem, destino);
			printInfo();
						
			//Moves them again
			moveDiscs(n-1, auxiliar, destino, origem);
			
		}
	}
	
	private void moveOneDisc(Stack<E> origem, Stack<E> destino){
		move++;
		destino.push(origem.top());
		origem.pop();
	
	}
	
	public int move(){
		return move;
	}
}

