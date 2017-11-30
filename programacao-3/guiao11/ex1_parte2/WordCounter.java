package aula11.ex1_parte2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
		lines.stream().flatMap(x -> Arrays.stream(x.split(" "))).forEach(word -> {
			if(wordCount.containsKey(word))
				wordCount.put(word,new Integer(wordCount.get(word)+1));
			else
				wordCount.put(word, new Integer(1));				
		});
	}
	
	public void countWords(String filename) throws IOException {
		Set<String> differentWordsSet = new HashSet<>();
		List<String> lines = Files.readAllLines(Paths.get(filename));
		lines.stream().flatMap(line -> Arrays.stream(line.split(" "))).forEach(word -> {
				differentWordsSet.add(word);
				totalWords++;
		});
		differentWords = differentWordsSet.size();
	}
	
	public void writeInfoToFile(String filename) {
		PrintWriter pwf = null;
		try {
			pwf = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		pwf.println(mapToString());
		pwf.close();
	}
	
	public String mapToString() {
		return wordCount.keySet().stream().map(key -> key+"\t"+wordCount.get(key)).collect(Collectors.joining("\n"));
	}
	
}
