import static java.lang.System.*;
import java.util.*;
import java.io.IOException;
import java.io.File;
import p2utils.*;

public class BigramCount2
{

  public static void main(String[] args) {
    HashTable<KeyValueList<Integer>> counts = new HashTable<KeyValueList<Integer>>(100000); // Usamos hash table!

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      analyseText(fin, counts); // atualiza contagens de bigramas
    }
    //Prints the information
    printCounts(counts);
    
    try{
		while(true){
			//Asks for the user's input
			out.print("Introduza uma palavra (ou Ctrl+D para terminar): ");
			mostFrequent(counts, new Scanner(in).nextLine());
		}
	}catch(NoSuchElementException e){}
  }

  // Read input text file word by word and count occurences of bigrams
  static void analyseText(File fin, HashTable<KeyValueList<Integer>> counts) {
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
			if(counts.contains(prevWord)){
				KeyValueList<Integer> kvl = counts.get(prevWord);
				if(kvl.contains(currWord))
					kvl.set(currWord, kvl.get(currWord)+1);
				else
					kvl.set(currWord, 1);
			}
			else{
				KeyValueList newKvl = new KeyValueList<Integer>();
				newKvl.set(currWord, 1);
				counts.set(prevWord, newKvl);
			}
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
  static void printCounts(HashTable<KeyValueList<Integer>> counts) {
    String keys[] = counts.keys();
    Arrays.sort(keys);
    File file = new File("output1");
    for (int i = 0; i < keys.length; i++){
		out.println(keys[i] + " -> " + counts.get(keys[i]));
	}
	out.println();
	
  }
    
  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(HashTable<KeyValueList<Integer>> counts, String word) {
	int count = 0;
    int max = -1;
    String mostFrequent = null;
    KeyValueList<Integer> kvl = counts.get(word); 
    String[] keys = kvl.keys();
	for (int i = 0; i < keys.length; i++){
		int value = kvl.get(keys[i]);
		if(value > max){
			max = value;
			mostFrequent = keys[i];
		}
		count += value;
		
	}
	float freq = 100*(float)max/(float)count;
	out.printf("A palavra mais frequente a seguir a '%s' é: %s\n", word, mostFrequent);
	out.println("Number of keys: " + keys.length);
	out.printf("Most frequent key: %s (%d/%d = %.2f%%)\n", mostFrequent, max, count, freq);
	
  }
}

