import java.io.*;
import java.util.Scanner;
import p2utils.*;
import static java.lang.System.*;

public class P124 {
	
	public static void main (String args[]) throws IOException{
		
		Scanner read = new Scanner(new File("numbers.txt"));
		HashTable<String> dict = new HashTable(20);
		
		//Loads the dictionary with the corresponding definitions
		while(read.hasNextLine()){
			String[] line = read.nextLine().split(" - ");
			dict.set(line[1], line[0]);
		}
		
		//This scan is necessary to read the echo input
		String arg = new Scanner(in).nextLine();
		Scanner sc = new Scanner(arg);
		
		//Gets all available definitions
		String[] keys = dict.keys();
		//The sum of all the numbers
		Queue<Long> queue = new Queue<>();
		
		//Loads the queue with all the numbers
		while(sc.hasNext()){
			String a = sc.next();
			String[] words = a.split("-");
			for(String w : words){
				if(dict.contains(w))
					queue.in(Long.parseLong(dict.get(w)));
			}
		}
		
		//Loads the product with the first element
		long sum = 0;
		long prev = -1;
		long next = -1;
		long product = queue.peek();
		
		do{
			prev = queue.peek();
			queue.out();
			if(!queue.isEmpty())
				next = queue.peek();
			//If prev < next it keeps multiplying
			if(prev < next){
				product *= next;
			}
			else{ //If it isn't it just adds to the sum
				sum += product;
				product = next;
			}
		}while(!queue.isEmpty());
		out.println(arg + " -> " + sum);
		
	}
}

