package aula2;
import java.util.*;
import java.io.*;

public class Game {
	
	private char[][] grid; //The 'soup of characters' (Sopa de Letras)
	private List<String> dict; //Dictionary with the words to look for
	private List<String> result;
	private final int N;
	
	public Game(String filename){
		grid = new char[80][80];
		Scanner scf = null;
		try {
			scf = new Scanner(new File(filename));
		}catch(FileNotFoundException e) {
			System.out.println("File "+filename+" does not exist.");
			System.exit(1);
		}
		//The first line must be read separately in order to get the dimensions of the grid
		String firstLine = scf.nextLine();
		int y = 0;
		N = firstLine.length(); //N = width = length of grid
		for(int x = 0; x < N;x++) {
			grid[y][x] = firstLine.charAt(x);
		}
		y++;
		dict = new ArrayList<>(N);
		
		while(scf.hasNextLine()) {
			String line = scf.nextLine();
			//Similar implementation for ; . or ' '
			if(!line.contains(",")) { //Adds the word to the grid
				for(int x = 0; x < N; x++) {
					grid[y][x] = line.charAt(x);
				}
				y++;
			}else { //If it contains special characters it adds the words to the dict
				for(String s : line.split(", ")) {
					dict.add(s.toUpperCase());
				}
			}
		}
		result = new LinkedList<>();
	}
	
	public void play() {
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				search(x, y);
			}
		}
	}
	
	public void printOutput() {		
		for(String r : result) {
			System.out.println(r);
		}
	}
	
	private void search(int x, int y) { //X and Y of the current position
		
		//Iterates through every word in the dictionary
		for(String word : dict) {
			if(grid[y][x] == word.charAt(0)) { //May be the start of a word
				Position currentPos = new Position(y,x);
				/* Horizontal search*/
				if(x+word.length()-1<N) { //May be to the RIGHT
					String dir = "right";
					if(foundWord(word, dir, currentPos,new Position(y,x+word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				if(x-word.length()+1>=0) { //May be to the LEFT
					String dir = "left";
					if(foundWord(word, dir, currentPos,new Position(y,x-word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				/* Vertical search*/
				if(y+word.length()-1<N) { //May be DOWN
					String dir = "down";
					if(foundWord(word, dir, currentPos,new Position(y+word.length(),x))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				if(y-word.length()+1>=0) { //May be UP
					String dir = "up";
					if(foundWord(word, dir, currentPos,new Position(y-word.length(),x))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				/* Diagonal Search */
				if(y+word.length()-1<N && x+word.length()-1<N) { //May be DOWNRIGHT
					String dir = "downright";
					if(foundWord(word, dir, currentPos,new Position(y+word.length(),x+word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				if(y-word.length()+1>=0 && x+word.length()-1<N) { //May be UPRIGHT
					String dir = "upright";
					if(foundWord(word, dir, currentPos,new Position(y-word.length(),x+word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				if(y+word.length()-1<N && x-word.length()+1>=0) { //May be DOWNLEFT
					String dir = "downleft";
					if(foundWord(word, dir, currentPos,new Position(y+word.length(),x-word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
				
				if(y-word.length()+1>=0 && x-word.length()+1>=0) { //May be UPLEFT
					String dir = "upleft";
					if(foundWord(word, dir, currentPos,new Position(y-word.length(),x-word.length()))) {
						result.add(word+"	"+currentPos+"	"+dir);
					}
				}
			}
		}
	}
	
	private boolean foundWord(String word, String dir, Position lowerLimit, Position upperLimit) {
		
		int incrementX = 0;
		int incrementY = 0;
		
		int x = lowerLimit.x;
		int y = lowerLimit.y;
		
		if(dir.contains("up")) {
			incrementY = -1;
		}else if(dir.contains("down")) {
			incrementY = 1;
		}
		
		if(dir.contains("left")) {
			incrementX = -1;
		}else if(dir.contains("right")) {
			incrementX = 1;
		}
		
		String tempWord = "";
		
		for(int i = 0; i < word.length(); i++) {
			tempWord += grid[y][x];
			x += incrementX;
			y += incrementY;
		}
		
		return tempWord.equals(word);
	}
	
	class Position{
		
		private final int x;
		private final int y;
		
		private Position(int y, int x){
			this.y = y;
			this.x = x;
		}
		
		public String toString() { return (y+1) + "," + (x+1); }
		
	}
	
}



