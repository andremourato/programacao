import java.util.*;
public class guiao10e1 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String[] args) {
		
		Statistic xstat = new Statistic();
		xstat.numLower=0;
		xstat.numUpper=0;
		xstat.numbers=0;
		xstat.numVowel=0;
		xstat.numCons=0;
		xstat.numChar=0;
		System.out.print("Frase a analisar: "); //Pede ao utilizador que escreva a frase
		String line = read.nextLine(); //le a frase
		updateStats(line, xstat);
		
		//Apresenta a informação sobre a frase
		System.out.printf("Numero de carateres minusculos -> %d\n",xstat.numLower);
		System.out.printf("Numero de carateres maiusculos -> %d\n",xstat.numUpper);
		System.out.printf("Numero de carateres numericos -> %d\n",xstat.numbers);
		System.out.printf("Numero de vogais -> %d\n",xstat.numVowel);
		System.out.printf("Numero de consoantes -> %d\n",xstat.numCons);
	}
	public static void updateStats(String line, Statistic xstat){
		
		Scanner readLine = new Scanner(line);
		while(readLine.hasNext()){
			String word = readLine.next();
			for(int i=0; i<word.length();i++){
				xstat.numChar++;
				if(Character.isLowerCase(word.charAt(i))) xstat.numLower++;
				if(Character.isUpperCase(word.charAt(i))) xstat.numUpper++;
				if(Character.isDigit(word.charAt(i))) xstat.numbers++;
				if(isVowel(word.charAt(i))) xstat.numVowel++;
			}
			xstat.numCons = xstat.numChar-xstat.numbers-xstat.numVowel; //calcula o numero de consoantes
		}
	}
	
	public static boolean isVowel(char c){ // verifica se o carater é vogal
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
		if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U') return true;
		else return false;
	}
}

class Statistic{
	int numLower;
	int numUpper;
	int numbers;
	int numVowel;
	int numCons;
	int numChar;
}

