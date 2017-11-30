package aula11.ex1_parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCounter {
	
	private Map<String, Integer>  wordCount;
	public int differentWords;
	public int totalWords;
	
	public WordCounter(String filePath) throws IOException {
		wordCount = new TreeMap<>();
		readWords(filePath);
		countWords(filePath);
	}
	
	public void readWords(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename));
		for(String line : lines) {
			for(String word : line.split(" ")) {
				if(wordCount.containsKey(word))
					wordCount.put(word,wordCount.get(word)+1);
				else
					wordCount.put(word, 1);
			}
		}
	}
	
	public void countWords(String filename) throws IOException {
		Set<String> differentWordsSet = new HashSet();
		List<String> lines = Files.readAllLines(Paths.get(filename));
		for(String line : lines) {
			for(String word : line.split(" ")) {
				differentWordsSet.add(word);
				totalWords++;
			}
		}
		differentWords = differentWordsSet.size();
	}
	
	public void printInfoToFile(String filename) {
		PrintWriter pwf = null;
		try {
			pwf = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String key : wordCount.keySet()) {
			pwf.println(key+"\t"+wordCount.get(key));
		}
		pwf.close();
	}
	
}
