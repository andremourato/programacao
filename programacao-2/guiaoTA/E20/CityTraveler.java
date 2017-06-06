import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class CityTraveler
{
	public static void main(String[] args) throws IOException{
		
	if (args.length == 0)
    {
      System.err.println("Usage: java -ea CityTraveler <FICH1> <FICH2> ...");
      System.exit(1);
    }
		
		for(String city : args){
			Scanner read = new Scanner(new File(city));
			while(read.hasNextLine()){
				String person = read.nextLine();
				if(!info.contains(person)){
					LinkedList<String> list = new LinkedList<String>();
					list.addLast(city);
					info.set(person, list);
				}
				else{
					LinkedList<String> list = info.get(person);
					list.addLast(city);
					info.set(person, list);
				}
				
			}
		}
		//Prints
		printInfo();
	}
	
	static void printInfo(){
		String[] keys = info.keys();
		for(String name : keys)
			out.printf("%-15s:  %s\n", name, info.get(name).toString(""," ",""));
					
	}
	
	static HashTable<LinkedList<String>> info = new HashTable<>(20);

}

