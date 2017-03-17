import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class p55 {
	
	public static void main (String[] args) throws IOException{
		
		Scanner scf = openValidScanner(args[0]);
		int column = 0;
		try {
			column = Integer.parseInt(args[1]);
		}catch(NumberFormatException e){
			out.println("\nInvalid argument. Existing program.");
			exit(1);
		}
		String[] line = null;
		out.println();
		do{
			line = scf.nextLine().split(" "); //stores all the tokens in a string array
			try{
				out.println(line[column-1]);
			}catch(ArrayIndexOutOfBoundsException e){ //in case there is no element of index 'column-1'
				out.println();
			}
		}while(scf.hasNextLine());
	}
	
	static Scanner openValidScanner(String fileName) throws IOException{
		
		File input = new File(fileName);
		if(!input.exists()){
			out.printf("\nFile '%s' not found. Exiting program.\n",fileName);
			exit(1);
		}
		if(!input.canRead()){
			out.printf("\nFile '%s' cannot be read. Exiting program.\n",fileName);
			exit(1);
		}
		if(input.isDirectory()){
			out.printf("\nFile '%s' is a directory. Exiting program.\n",fileName);
			exit(1);
		}				
		return new Scanner(input);
	}
}
