import java.io.*;
import static java.lang.System.*;

public class p67 {
	
	public static void main (String[] args) {
		
		String path;
		if(args.length == 0 || args.length > 2){
			out.println("Usage <[pattern]> <[path]>");
			exit(1);
		}
		if(args.length == 1) path = ".";
		else path = args[1];
		File dir = new File(path);
		printFileLocations(dir, args[0]);
		
	}
	
	static void printFileLocations(File file, String pattern){
		
		if(file.isFile() && file.getName().indexOf(pattern) != -1) out.println(file.getPath());
		if(file.isDirectory()){
			File[] dir = file.listFiles();
			for(File f : dir){
				printFileLocations(f, pattern);
			}
		}
	}
}

