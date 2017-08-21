import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class JustifiedText{
	public static void main(String[] args) throws IOException{
		if(args.length != 2){
			err.println("Usage: java -ea JustifiedText <NUM-COLUMNS> <FILE>");
			exit(1);
		}
		int n = -1;
		try{
			n = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			err.print("ERROR: argument "+args[0]+" is not an integer number!");
			exit(1);
		}
		Scanner read = new Scanner(new File(args[1]));
		String text = "";
		Queue<String> queue = new Queue<>();
		//Goes over every line in the file
		while(read.hasNextLine()){
			String line = read.nextLine();
			if(line.length() != 0){
				Scanner lineScanner = new Scanner(line);
				while(lineScanner.hasNextLine()){
					String word = lineScanner.next();
					queue.in(word);
				}
			}else
				queue.in("\n");
		}
		String curLine = ""; //Represents the current line that is being analysed
		String next = ""; //Represents the next word to be analysed
		while(!queue.isEmpty()){
			next = queue.peek();
			int numNewChars = 1 + next.length();
			int numChars = curLine.length()+numNewChars;
			if(next != "\n"){
				if(numChars <= n){ //If the word fits in the line
					curLine += " "+next;
					curLine = curLine.trim();
				}else{ //If the word doesn't fit in the line. Resets all variables
					text += insertSpaces(curLine, n)+"\n";
					curLine = next;
				}
			}else{
				text += curLine+"\n\n";
				curLine = "";
			}
			if(queue.size() == 1){//If it's the last word to be processed
				text += curLine; //Makes sure the last paragraph's words are separated by only 1 space
			}
			queue.out();
		}
		out.println(text);
	}
	
	static String insertSpaces(String s, int n){ //'n' is the number of columns
		String newStr = "";
		s = s.trim();
		int numWords = s.split(" ").length;
		int spaces = n - s.length(); //The number of spaces necessary to complete n columns
		float avgNumSpaces = (float)spaces/(float)(numWords-1); //number of spaces between each word
		int numSpaces = (int)avgNumSpaces; //Minimum number of spaces between words
		float excessDec = avgNumSpaces - numSpaces;
		int excess = (int)(excessDec * (numWords-1)); //Excess spaces between words
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){ //If it's a space it will fill it up
				for(int j = numSpaces; j > 0; j--){//Fills the necessary spaces
					newStr += " ";
				}
				if(excess > 0){
					newStr += " ";
					excess--;
				}
			}
			newStr += s.charAt(i);
		}
		return newStr;
	}

}

