import java.util.Scanner;
import java.io.*;

public class guiao84 {
	
	public static void main (String[] args) throws IOException {
		String file = "program.txt";
		File program = new File(file);
		if(!program.exists()){ 
			System.out.print("ERROR: The file "+file+" does not exist.");
			System.exit(2);
		}
		Scanner scf = new Scanner(program); //reads the file
		//PrintWriter pwf = new PrintWriter();
		while(scf.hasNextLine()){
			String line = scf.nextLine();//reads the next line
			if(line.startsWith("//")) line = "";
		}
		scf.close(); //closes the scanner
		//pw.close(); //closes the printwriter
		
	}
}

