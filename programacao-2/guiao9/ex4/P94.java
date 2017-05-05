import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import p2utils.*;

public class P94 {

  static SortedList<String> lst = new SortedList<String>();
	
  public static void main(String[] args) throws IOException // Note that the Program is not robust!
  {
    if (args.length != 1) {
      err.println("Usage: java P94 <file>");
      exit(1);
    }
    File fin = new File(args[0]);
    String[] words = extractsWords(fin);
    lst.print();
    out.println("Number of different words is: "+lst.size());
  }

  // Read words from a file, return words in an array
  static String[] extractsWords(File fin) throws IOException {
    assert fin != null;
    assert !fin.isDirectory(); // Note that this precondition does not 100% ensure this kind of assertion!
    assert fin.canRead();      // Note that this precondition does not 100% ensure this kind of assertion!

    // count the words
    int n = 0;
    Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
    // (words are delimited by 1 or more punctuation or whitespace char)
	while (scf.hasNext()) {
		String word = scf.next();
		if(!lst.contains(word))
			lst.insert(word);
		n++;
	}
    scf.close();

    String[] result = new String[n];

    // read the words
    int i = 0;
    scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
    while(scf.hasNext()) {
      result[i] = scf.next();
      i++;
    }
    scf.close();

    return result;
  }

}
