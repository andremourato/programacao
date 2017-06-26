import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class Restaurante {

	static HashTable<Integer> stock = new HashTable<>(100);
	static Queue<HashTable<Integer>> queue = new Queue<>();
	
	public static void main(String[] args) throws IOException{
		for(String arg : args){
			processOrders(arg);
		}
		
		printStock();
		printPending();

	}
	
	static void processOrders(String filename) throws IOException{
		Scanner read = new Scanner(new File(filename));
		while(read.hasNextLine()){
			String action = read.nextLine();
			
			//Food comes in
			if(action.contains("entrada:"))	{
				String stockIn = action.split(" ")[1];
				if(stock.contains(stockIn))
					stock.set(stockIn, stock.get(stockIn) + 1);
				else
					stock.set(stockIn, 1);
			}
			
			//Order requested
			else if(action.contains("saida:")){
				//Adds the order to the queue
				String[] items = action.split(" ");
				HashTable<Integer> hash = new HashTable<>(30);
				for(int i = 1; i < items.length; i++){
					String[] order = items[i].split(":");
					hash.set(order[0], Integer.parseInt(order[1]));
				}
				queue.in(hash);			
			}
			if(!queue.isEmpty()){ //Serves the next order in the queue if possible
				HashTable<Integer> nextOrder = queue.peek();
				if(canBeServed(nextOrder)){
					serveOrder(nextOrder);
					out.printf("Refeicao servida : %s\n", orderToString(nextOrder));
				}
			}
		}
		
	}
	
	static void serveOrder(HashTable<Integer> order){
		String[] keys = order.keys();
		for(String key : keys){
			stock.set(key, stock.get(key) - order.get(key));
		}
		queue.out();			
	}
	
	static boolean canBeServed(HashTable<Integer> order){
		String[] keys = order.keys();
		boolean serve = true;
		for(String key : keys){
			if(stock.contains(key)){
				if(order.get(key) > stock.get(key)){
					serve = false;
					break;
				}
			}
			else{
				serve = false;
				break;
			}
		}
		return serve;
	}
	
	static void printStock(){
		String[] keys = stock.keys();
		out.println("Comida em stock:");
		for(String key : keys){
			out.printf("  %s: %d\n", key, stock.get(key));
		}		
	}
	
	static void printPending(){
		while(!queue.isEmpty()){
			out.printf("Refeição pendente: %s\n", orderToString(queue.peek()));
			queue.out();
		}
		
	}
	
	static String orderToString(HashTable<Integer> order){
		String str = "";
		String[] keys = order.keys();
		for(String key : keys){
			str += key+":"+order.get(key)+" ";
		}
		return str;
	}

}

