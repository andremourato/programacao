import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class PhoneCalls
{
	public static void main(String[] args) throws IOException{
		for(String arg : args){
			if(arg.contains(".nms")){
				Scanner read = new Scanner(new File(arg));
				while(read.hasNextLine()){
					String[] line = read.nextLine().split(" ");
					hash.set(line[0], line[1] + " " + line[2]);
				}
			}
			else if(arg.contains(".cls")){
				Scanner scf = new Scanner(new File(arg));
				while(scf.hasNextLine()){
					String[] line = scf.nextLine().split(" ");
					String caller = line[0];
					String called = line[1];
					if(hash.contains(line[0]))
						caller = hash.get(line[0]);
					if(hash.contains(line[1]))
						called = hash.get(line[1]);
					if(calls.contains(line[0])){
						KeyValueList<String> kvl = calls.get(line[0]);
						kvl.set(line[2], line[1]);
						calls.set(line[0], kvl);
					}
					else{
						KeyValueList<String> kvl = new KeyValueList<>();
						kvl.set(line[2], line[1]);
						calls.set(line[0], kvl);
					}
					out.printf("%s to %s (%s seconds)\n", caller, called, line[2]);
				}
			}
			else{
				printCallsMadeBy(arg);
				printCallsMadeTo(arg);
			}
		}
		
	}
	
	static void printCallsMadeBy(String number){
		String name = number;
		if(hash.contains(number))
			name = hash.get(number);
		out.println("\nCalls made by " + name + ":");
		if(calls.contains(number)){
			KeyValueList<String> kvl = calls.get(number);
			String[] keys = kvl.keys();
			for(String k : keys){
				String called = kvl.get(k);
				if(hash.contains(called))
					called = hash.get(called);
				out.printf("	- to phone %s (%s seconds)\n", called, k);
			}
		}
	}
	
	static void printCallsMadeTo(String number){
		String name = number;
		if(hash.contains(number))
			name = hash.get(number);
		out.println("\nCalls made to " + name + ":");
		String[] allKeys = calls.keys();
		for(String caller : allKeys){
			if(calls.contains(caller)){
				KeyValueList<String> kvl = calls.get(caller);
				String[] keys = kvl.keys();
				for(String s : keys){
					String called = kvl.get(s);
					if(called.equals(number)){
						String person = caller;
						if(hash.contains(caller))
							person = hash.get(caller);
						out.printf("	- from phone %s (%s seconds)\n", person, s);
					}
				}
			}
		}
	}
	
	static HashTable<KeyValueList> calls = new HashTable<>(1000);
	static HashTable<String> hash = new HashTable<>(1000);
}

