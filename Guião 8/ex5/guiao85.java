import java.util.Scanner;
import java.io.*;

public class guiao85 {
	
	public static void main (String[] args) throws IOException {
		File programIn = new File("programIn.txt");
		File programOut = new File("programOut.txt");
		if(!programIn.exists()){ 
			System.out.print("ERROR: The file 'programIn.txt' does not exist.");
			System.exit(2);
		}
		Scanner scf = new Scanner(programIn); //reads the file 'programIn.txt'
		PrintWriter pwf = new PrintWriter(programOut); //writes in the file 'programOut.txt'
		while(scf.hasNextLine()){
			String line = scf.nextLine();//reads the next line
			if(!line.startsWith("//")) pwf.println(line);
			if(line.startsWith("/*")){
				/*do{
					pwf.println();
				}while(scf.next()!="");*/
			}
		}
		
		scf.close(); //closes the scanner
		pwf.close(); //closes the printwriter
		
	}
}

