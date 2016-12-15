import java.util.Scanner;
import java.io.*;

public class guiao85 {
	
	public static void main (String[] args) throws IOException {
		String fileIn = "programIn.txt";
		String fileOut = "programOut.txt";
		File programIn = new File(fileIn);
		File programOut = new File(fileOut);
		if(!programIn.exists()){ 
			System.out.print("ERROR: The file "+fileIn+" does not exist.");
			System.exit(2);
		}
		Scanner scf = new Scanner(programIn); //reads the file
		PrintWriter pwf = new PrintWriter(programOut);
		while(scf.hasNextLine()){
			String line = scf.nextLine();//reads the next line
			if(line.startsWith("//")) line = "";
			pwf.println(scf.nextLine());
		}
		scf.close(); //closes the scanner
		pwf.close(); //closes the printwriter
		
	}
}

