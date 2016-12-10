/*
 * André Mourato/ NºMec: 84745
*/
import java.io.*;
import java.util.*;
public class guiao91 {
	
	public static void main (String args[]) throws IOException {
		Scanner read = new Scanner(System.in); //Scanner de texto
		String file;
		System.out.print("Nome do ficheiro: ");
		file = read.nextLine();
		File my_file = new File(file);
		if(verify(my_file,file)){
			Scanner readFile = new Scanner(my_file); //Scanner do ficheiro
			while(readFile.hasNextLine()){
				System.out.printf("%s\n",readFile.nextLine());//Programa lê as linhas 
			}
		}	
	}
	
	//Função de verificação
	public static boolean verify(File nameFile, String file){
		
		if(!nameFile.exists()){
			System.out.printf("ERROR: input name %s is not a file\n", file);
			return false;
		}else if(nameFile.isDirectory()){
			System.out.printf("ERROR: input name %s is a directory\n", file);
			return false;
		}else if(!nameFile.canRead()){
			System.out.printf("ERROR: input name %s can't be read\n", file);
			return false;
		}
		return true;
	}
}
