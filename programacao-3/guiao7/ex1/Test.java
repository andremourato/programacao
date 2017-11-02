package aula7.ex1;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException{
		
		Aeroporto saCarneiro = new Aeroporto("companhias.txt","voos.txt");
		saCarneiro.printToScreen();
		System.out.println();
		
		if(saCarneiro.writeToFile("Infopublico.txt")) 
			System.out.println("Sucessfully writen to file\n");
		else 
			System.out.println("ERROR: Cannot write to file\n");
		
		System.out.println();
		saCarneiro.printAverageDelay();
		System.out.println();
		
		if(saCarneiro.writoToBinaryFile("Infopublico.bin")) 
			System.out.println("Sucessfully writen to binary file\n");
		else
			System.out.println("ERROR: Cannot write to binary file\n");
		
		if(saCarneiro.readFromBinaryPrint("Infopublico.bin")) 
			System.out.println("Sucessfully read binary file and printed to the screen!\n");
		else
			System.out.println("ERROR: Cannot read from binary file\n");
	}

}
