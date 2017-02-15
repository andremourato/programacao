import java.io.*;
import java.util.Scanner;

public class g1e7 {
	
	public static void main (String[] args) throws IOException{
		//name of the files
		String fileInName = "text1.txt"; //I used standard names for the files, but you just need to pass these names
		String fileOutName = "text2.txt"; // as arguments to method main in the command line
		File fileIn = new File(fileInName); //File from which the text is copied
		checkFileIn(fileIn, fileInName);
		checkFileOut(fileOutName);
		File fileOut = new File(fileOutName); //File to where the text is copied
		writeToFile(fileIn, fileOut); //prints the content of fileIn to fileOut
		System.out.print("Operation complete");
	}
	
	static void checkFileIn(File file, String name){
		System.out.printf("Verifying if %s exists...\n",name);
		if(!file.exists()){
			System.out.printf("ERROR: &s doesn't exist!\n",name);
			System.exit(1);
		}
		if(!file.canRead()){
			System.out.printf("ERROR: %s cannot be read\n");
			System.exit(2);
		}
		System.out.println("The input file is valid.");
	}
	
	static void checkFileOut(String name){
		Scanner read = new Scanner(System.in);
		File file = new File(name);
		if(file.exists()){ //checks if fileOut exists and is valid
			System.out.print("The file already exists. Do you which to delete it? (y/n)");
			String option;
			do{
				option = read.nextLine();
				if(option.equals("y"))file.delete();
				else if(option.equals("n")) System.exit(1);
				else System.out.println("Only y or n.");
			}while(!option.equals("y")&&!option.equals("n"));
		}
	}
	
	static void writeToFile(File fileIn, File fileOut)throws IOException{ //writes the content of fileIn to fileOut
		Scanner scf = new Scanner(fileIn);
		PrintWriter pw = new PrintWriter(fileOut);
		do{
			String line = scf.nextLine();
			pw.println(line);
		}while(scf.hasNextLine());
		pw.close();
		scf.close();
	}
}

