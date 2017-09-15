/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/

import java.util.*;
import static java.lang.System.*;

public class G1E1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(in);
		out.print("Input: ");
		String input = read.nextLine();
		String[] words = input.split(" ");
		read.close();
		System.out.println("Number of numeric characters: "+countNumbers(input));
		System.out.println("Is Upper Case: "+(input.toUpperCase().equals(input)));
		System.out.println("Is Lower Case: "+(input.toLowerCase().equals(input)));
		System.out.println("Number of words: "+words.length);
		String newStr = null;
		for(String word : words) {
			newStr = "";
			System.out.printf("\nOriginal word: \"%s\"\n",word);
			for(int i = 0; i < word.length()-1; i+=2) {
				newStr += String.valueOf(word.charAt(i+1))+String.valueOf(word.charAt(i));
			}
			if(word.length() % 2 != 0) newStr += word.charAt(word.length()-1);
			System.out.printf("Modified word: \"%s\"\n",newStr);
		}
	}
	
	static int countNumbers(String str) {
		int num = 0;
		for(int i = 0; i < str.length();i++) {
			if(Character.isDigit(str.charAt(i))) num++;
		}
		return num;
	}

}
