import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class P82{
	
	public static void main(String[] args) throws IOException{
		if(args.length == 0){
			out.println("Usage: java -ea P82 file1 ...");
		}
		
		SortedListInt numbers = new SortedListInt();
		File file;
		
		for(String s : args){ //Iterates through every given file
			file = new File(s);
			assert file.isFile();
			numbers = insertNumbers(numbers, new Scanner(file));
			assert numbers.isSorted();
		}
		numbers.print();

	}
	
	static SortedListInt insertNumbers(SortedListInt numbers, Scanner read){
		if(!read.hasNext()) return numbers;
		try{// If it's an integer, inserts it in the list
			int elem = Integer.parseInt(read.nextLine());
			numbers.insert(elem);
		}catch(NumberFormatException e){
			//Else it does nothing, meaning that it isn't an integer
		}
		return insertNumbers(numbers, read);
	}

}


