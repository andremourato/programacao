import java.io.*;
import java.util.Scanner;
public class guiao86 {
	
	public static void main (String[] args) throws IOException {
		Scanner read = new Scanner(System.in);
		System.out.println("Nome do ficheiro: ");
		String nameOld = read.nextLine();
		File fileOld = new File(nameOld);
		System.out.println();
		System.out.println("Novo nome do ficheiro: ");
		String nameNew = read.nextLine();
		File fileNew = new File(nameNew);
		checkStatus(fileOld, nameOld, fileNew, nameNew);
		Scanner scf = new Scanner(fileOld);
		PrintWriter pwf = new PrintWriter(nameNew);
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			pwf.println(line);
		}
		scf.close();
		pwf.close();
	}
	
	public static void checkStatus(File fileOld, String nameOld, File fileNew, String nameNew){
		if(!fileOld.exists()){
			System.out.print("ERROR: The file "+nameOld+" doesn't exist.");
			System.exit(1);
		}
		if(!fileOld.canRead()){
			System.out.print("ERROR: The file "+nameOld+" cannot be read.");
			System.exit(2);
		}
		if(fileNew.exists()){
			System.out.print("ERROR: The file "+nameNew+" already exists.");
			System.exit(3);
		}
	}
}

