import java.util.*;
public class guiao10e2 {
	
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		String line;
		do{
			System.out.print("Escreva a frase: ");
			line = read.nextLine();
			System.out.printf("Acronimo: %s\n", acronimo(line));
		}while(line.length()!=0);
	}
	public static String acronimo(String line){
		Scanner readLine = new Scanner(line);
		String acronimo = "";
		while(readLine.hasNext()){
			String word = readLine.next();
			char firstChar = word.charAt(0);
			if(Character.isUpperCase(firstChar)) acronimo += firstChar;
		}
		return acronimo;
	}
}

