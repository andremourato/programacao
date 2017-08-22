import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import pt.ua.p2utils.*;

public class AllAnagrams
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1)
    {
      err.println("Uso: java -ea AllAnagrams <Ficheiro>");
      exit(1);
    }
    long time = nanoTime();
    LinkedList<LinkedList<String>> anagrams = findAnagrams(args[0]);
    time = nanoTime() - time;
    out.println(anagrams);
    out.printf("Found %d anagram groups", anagrams.size());
    out.printf(" in %.3f seconds\n", time/1e9);
  }

  // A sorted version of the string str:
  //   sortedString("isentas") -> "aeinsst".
  //   sortedString("sinetas") -> "aeinsst".
  static String sortedString(String str)
  {
    char[] a = str.toCharArray();
    Arrays.sort(a);
    return new String(a);
  }

  // complete this function
  static LinkedList<LinkedList<String>> findAnagrams(String FileName) 
    throws IOException 
  {
	//File stuff
    File fin = new File(FileName);
    Scanner scin = new Scanner(fin);
    //Algorithm
    LinkedList<LinkedList<String>> anagrams = new LinkedList<>();
    int expectedNumWords = (int)(fin.length()/10.0); // estimating around 10 bytes per word
	HashTable<LinkedList<String>> dict = new HashTable<>(expectedNumWords); //Contains elements of type (sortedString, linkedlist (of anagrams))

    while(scin.hasNext())
    {
	  LinkedList<String> list = new LinkedList<String>();
      String word = scin.next();
	  String sortedWord = sortedString(word);
	  if(dict.contains(sortedWord)){ //If it exists, gets the list associated with that key
		list = dict.get(sortedWord);
	  }else{ //If it doesn't exist inserts an empty list in that position
		dict.set(sortedWord, list);
	  }
	  list.addLast(word); //In the end adds the word to the list of anagrams
    }
    scin.close();

    String[] keys = dict.keys();
    for(String key : keys){
		LinkedList<String> tempList = dict.get(key);
		if(tempList.size() > 1) //If there is only 1 element in the list, it's useless, therefore it will be discarded
			anagrams.addLast(tempList);
	}

    return anagrams;
  }
}

