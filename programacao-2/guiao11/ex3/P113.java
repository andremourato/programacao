import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import p2utils.ImprovedKeyValueList;

public class P113
{

  public static void main(String[] args) throws IOException {
    ImprovedKeyValueList<Integer> counts = new ImprovedKeyValueList<>();

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      if (fin.exists() && fin.canRead()) {
        Scanner scf = new Scanner(fin);
        while (scf.hasNextLine()) { // Processa cada linha
          String line = scf.nextLine();
          // Divide a linha em "palavras", considerando como separador
          // qualquer sequência de 1 ou mais carateres não alfanuméricos:
          String[] palavras = line.split("[^\\p{Alnum}]+");
          for (int i = 0; i < palavras.length; i++) { // Processa cada palavra
			String str = palavras[i].toLowerCase();
			if(!str.equals("")){ //It must not count empty strings
				if(counts.contains(str))
					counts.set(str, counts.get(str)+1);
				else
					counts.set(str, 1);
			}
          }
        }
        scf.close();
      }
      else {
        err.println("ERRO: Nao foi possivel ler do ficheiro "+args[a]);
      }
    }
    out.println(counts.toString("Results:\n", ";\n", "\nEnd"));
    out.println(counts.toString()); // mesma lista, outro formato
    mostFrequent(counts);
  }

  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(ImprovedKeyValueList<Integer> counts) {
		int max = -1;
		int total = 0;
		String str = "";
		String[] keys = counts.keys();
		for(int i = 0; i < counts.size(); i++){
			String key = keys[i];
			int elem = counts.get(key);
			total += elem;
			if(elem > max){
				max = elem;
				str = key;
			}
		}
		out.printf("Most Frequent: %s (%.2f%%)\n", str, 100*(float)max/(float)total);
  }
}

