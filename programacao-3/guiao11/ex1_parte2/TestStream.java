package aula11.ex1_parte2;

import java.io.IOException;

public class TestStream {
	
	public static void main(String[] args) throws IOException {
		WordCounter wc = new WordCounter("text_file.txt");
		System.out.println("Número Total de Palavras: "+wc.totalWords);
		System.out.println("Número de Diferentes Palavras: "+wc.differentWords);
		System.out.println(wc.mapToString());
	}
	
}
