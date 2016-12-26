import java.util.*;
public class guiao10e3 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Frase: ");
		String line = read.nextLine();
		int wordCount = countWords(line);
		System.out.print(wordCount);
	}
	
	public static int countWords(String line){
		Scanner readString = new Scanner(line);
		String word;
		int wordCount=0;
		int numValidChars;
		int numChars;
		while(readString.hasNext()){ //percorre a string toda
			word = readString.next(); //le a palavra
			numChars = word.length(); //determina o numero de carateres que a palavra contem
			numValidChars = 0;
			for(int i=0;i<word.length();i++){
				char wordCharacter = word.charAt(i);
				if(Character.isDigit(wordCharacter)||Character.isLetter(wordCharacter)) numValidChars++; //exclui carateres especiais
			}
			if(numValidChars>=numChars-1) wordCount++; //verifica se sao palavras. se sim, conta-as
		}
		return wordCount;
	}
}

