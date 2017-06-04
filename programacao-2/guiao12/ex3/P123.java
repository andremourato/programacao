import java.io.*;
import java.util.Scanner;
import p2utils.*;
import static java.lang.System.*;

public class P123 {
	
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
		//It's a simplified version of:
		//Scanner scan = new Scanner(in);
		//String arg = scan.nextLine();
		Scanner sc = new Scanner(arg);
		
		//Gets all available definitions
		String[] keys = dict.keys();
		
		//Prints the definition of each argument
		while(sc.hasNext()){
			//This is to split a word in case it contains '-'
			//For example: 'twenty-four' will be read has
			//'twenty' and 'four' separately
			String[] words = sc.next().split("-");
			for(String s : words){
				//If the dictionary contains the defition
				//It prints it
				if(dict.contains(s))
					out.print(dict.get(s) + " ");
				else //Else it just prints the original word
					out.print(s + " ");
			}
		}
		out.println();
		
	}
}

