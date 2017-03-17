import java.util.*;
import java.io.*;
import static java.lang.System.*;

/**
 *	Defensive programming might not be aplied in the best way possible
 *  , but my objective is to test as many different ways of
 * 	detecting errors as possible.
 */

public class p52 {
	
	public static void main (String[] args) throws IOException{
		
		Scanner read = null;
		PrintWriter pwf = null;
		File input = null;
		File output = null;
		try{
			input = openInputFile(args[0]); //Validates the input file before returning it
			read = new Scanner(input);
			output = openOutputFile(args[1]); //Validates the output file before returning it
			pwf = new PrintWriter(output);
		}catch(FileNotFoundException e){ //This is useless, because we verify the file before returning it. It's used just to test
			out.printf("\nFile '%s' specified, does not exist\n", args[0]);
			out.println("Exiting program.");
			exit(1);
		}catch(ArrayIndexOutOfBoundsException e){
			out.println("\nInvalid number of arguments.");
			out.println("Exiting program.");
			exit(1);
		}catch(Throwable e){ //In case an unknown exception is thrown
			out.println("Unknown Error. Existing program.");
			exit(1);
		}
		do{
			pwf.println(read.nextLine());
		}while(read.hasNextLine());
		pwf.close();
		read.close();
	}
	
	static File openOutputFile(String fname){
		Scanner sc = new Scanner(in);
		File output = new File(fname);
		if(output.exists()){ //the output file already exists
			if(!output.canWrite()){ //checks if it has permission to write in the output file
				out.printf("Cannot write to file '%s'.\n", fname);
				out.println("Exiting program.");
				exit(1);
			}
			String answer = "";
			do{ //Asks the user if they wish to overwrite the existing file's content
				out.printf("\nFile '%s' already exists. Do you wish to overwrite its content? (y/n)\n", fname);
				out.print("Answer: ");
				answer = sc.nextLine();
				if(!answer.equals("y")&&!answer.equals("n")) out.println("Please write either 'y' or 'n'.");
				if(answer.equals("n")){ //If the user doesn't want to overwrite the output. It exists the program
					out.println("Exiting program.");
					exit(1);
				}
				//else it runs the program normally
			}while(!answer.equals("y")&&!answer.equals("n"));
		}
		return output;
	}
	
	static File openInputFile(String fname){
		File input = new File(fname);
		
		if(!input.exists()){ //If the input file doesn't exist. It exits the program.
			out.printf("File '%s' does not exist.\n", fname);
			out.println("Exiting program.");
			exit(1);
		}
		if(!input.isFile()){ //If it isn't a file. It exists the program.
			out.printf("File '%s' is not a file.\n", fname);
			out.println("Exiting program.");
			exit(2);
		}
		if(!input.canRead()){ //If it can't read the input file. It exists the program.
			out.printf("Cannot read file '%s'.\n", fname);
			out.println("Exiting program.");
			exit(3);
		}
		//If the program reaches this point, the file is valid.
		return input;
	}
}

