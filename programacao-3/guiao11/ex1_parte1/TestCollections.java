package aula11.ex1_parte1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class TestCollections {
	
	public static void main(String[] args) throws IOException {
		
		List<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i,
			1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		List<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		List<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));

		figList.add(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		List<Rectangulo> quadList = new LinkedList<Rectangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
		System.out.println();
		
		Set<String> differentWords = new HashSet<String>();
		
		String filename = "text_file.txt";
		
		List<String> lines = Files.readAllLines(Paths.get(filename));
		int totalWords = 0;
		for(String line : lines) {
			for(String word : line.split(" ")) {
				differentWords.add(word);
				totalWords++;
			}
		}
		System.out.println("Número Total de Palavras: "+totalWords);
		System.out.println("Número de Diferentes Palavras: "+differentWords.size());
		
		WordCounter wc = new WordCounter(filename);
		wc.printInfoToFile("output.txt");
		
	}
	
	static double sumArea(List<? extends Figura> list) {
		
		double total = 0;
		Iterator it = list.iterator();
		while(it.hasNext())
			total += ((Figura)it.next()).area();
		return total;
	}
	
	static void printSet(Iterator iterator) {
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}