import java.util.*;
import java.io.*;
public class guiao87 {
	
	public static void main (String[] args) throws IOException {
		File fileOld = new File("original.txt");
		Scanner scf = new Scanner(fileOld);
		while(scf.hasNext()){
			String token = scf.next(); //reads the next token
			if(token.charAt(token.length()-1)== '.'&&scf.hasNext()){ //checks if the last character in the string is a dot
				token = token.toLowerCase(); //if so, it will change all the characters of the string to lower case and move to the next string
				System.out.print(token+" ");
				token = scf.next(); //the following string will be the first word in the next sentence (which requires the first character to be upper case)
				char firstChar = Character.toUpperCase(token.charAt(0)); //makes sure that only the first character of the next string is upper case
				System.out.print(firstChar); //prints the first character of the string
				for(int i=1;i<token.length();i++){ //prints every character of given string, since it's impossible to change string's characters
					char character = token.charAt(i);
					char lowerCase = Character.toLowerCase(character); //forces the characters to be lower case
					System.out.print(lowerCase);
				}
				System.out.print(" ");
			}else{
				String lowerCase = token.toLowerCase();
				System.out.print(lowerCase+" ");
			}
		}
	}
}
