import static java.lang.System.*;
import java.io.File;

import p2utils.LinkedList;

public class P73 {

	public static void main(String[] args) {
		if (args.length != 1) {
		  out.println("Uso: java -ea P73 <dir>");
		  exit(1);
		}

		File dir = new File(args[0]);

		// Verificar entrada
		if (!dir.exists()) {
		  err.printf("ERRO: %s nao existe!\n", dir);
		  exit(2);
		}

		LinkedList<File> files = recListFiles(dir);
		files.print();
	}

	/* Devolve uma lista com o conteúdo de um directório f
	*  e de todos os seus subdirectórios recursivamente.
	*/
	public static LinkedList<File> recListFiles(File f) {
		return recListFiles(new LinkedList<File>(), f);
	}
  
    private static LinkedList<File> recListFiles(LinkedList<File> flist, File f){
		
		if(f.isDirectory()){ //If it's a directory it will keep searching for more subdirectories
			flist.addLast(f); //Adds the current directory as an element of the list
			File[] dir = f.listFiles();
			for(File file : dir){
				recListFiles(flist, file); //Searches each subdirectory for more subdirectories
			}
		}
		else{ //If it reaches this point means that it is a file
			flist.addLast(f); //Therefore will add it to the list
		}
		return flist; //At last it will return the created LinkedList
	}
}
