import static java.lang.System.*;
import java.util.*;
import java.io.IOException;
import java.io.File;
import p2utils.HashTable;

public class BigramCount
{

  public static void main(String[] args) {
    HashTable<Integer> counts = new HashTable<>(100000); // Usamos hash table!

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      analyseText(fin, counts); // atualiza contagens de bigramas
    }
    
    printCounts(counts);
    
    mostFrequent(counts);
  }

  // Read input text file word by word and count occurences of bigrams
  static void analyseText(File fin, HashTable<Integer> counts) {
    try {
      Scanner scf = new Scanner(fin);
      scf.useDelimiter("[^\\p{IsAlphabetic}]+");
      // ^ Isto serve para especificar que o separador de "tokens" no scanner
      // será qualquer sequência de 1 ou mais carateres não alfabéticos.
      // Assim, cada token devolvido por scf.next() é uma palavra no sentido
      // mais convencional: uma sequência composta apenas de letras!

      String prevWord = null; // serve para guardar a palavra anterior
      prevWord = scf.next();

      while (scf.hasNext()) { // Processa cada palavra
        // palavra atual: é lida do scanner e normalizada:
        String currWord = scf.next().toLowerCase();
		if(prevWord !=null){
			String key = prevWord+" "+currWord;
			if(counts.contains(key))
				counts.set(key,counts.get(key) + 1);
			else
				counts.set(key, 1);
			prevWord = currWord;
		}
      }
      scf.close();
    }
    catch (IOException e) {
      err.printf("ERROR: %s\n", e.getMessage());
      exit(1);
    }
  }

  // Print each key (bigram) and its count
  static void printCounts(HashTable<Integer> counts) {
    String keys[] = counts.keys();
    Arrays.sort(keys);
    File file = new File("output1");
    for (int i = 0; i < keys.length; i++){
		out.println(keys[i] + ": " + counts.get(keys[i]));
	}
	
  }
    
  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(HashTable<Integer> counts) {
	int count = 0;
    int max = -1;
    String mostFrequent = null;
    String[] keys = counts.keys();
	for (int i = 0; i < keys.length; i++){
		int value = counts.get(keys[i]);
		if(value > max){
			max = value;
			mostFrequent = keys[i];
		}
		count += value;
		
	}
	float freq = 100*(float)max/(float)count;
	out.println("Number of keys: " + keys.length);
	out.printf("Most frequent key: %s (%d/%d = %.2f%%)\n", mostFrequent, max, count, freq);
	
	
  }
}

