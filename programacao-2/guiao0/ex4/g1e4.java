import java.util.Scanner;

public class g1e4 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Frase a traduzir: ");
		String sentence = read.nextLine();
		System.out.println(translateString(sentence));
	}
	
	static String translateString(String sentence){ //translates the sentece
		Scanner sc = new Scanner(sentence);
		String newSentence="";
		do{
			String word = sc.next();//the program reads each word in the sentence
			for(int i=0; i<word.length();i++){ //we search each character of the word
				if(word.charAt(i)=='l') newSentence+="u"; //it switches the 'l' for 'u'
				else if (word.charAt(i)=='L') newSentence+="U"; //same thing in upper case
				else if(word.charAt(i)!='r') newSentence+=word.charAt(i); //doesn't count the 'r'
			}
			newSentence += " ";//space between words
		}while(sc.hasNext()); //do until there are no words to search
		return newSentence;
	}
}

