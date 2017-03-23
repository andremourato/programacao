import static java.lang.System.*;
import java.io.*;

public class p65 {
	
	public static void main (String[] args) {
	
		if(args.length != 1){
			out.println("Wrong number of arguments");
			exit(1);
		}
		File dir = new File(args[0]);
		printListOfDirectories(dir);
	}
	
	static void printListOfDirectories(File file){
		
		out.println(file.getPath());
		if(file.isDirectory()){
			File[] dir = file.listFiles();
			for(File f : dir){
				printListOfDirectories(f);
			}
		}
	}
}

