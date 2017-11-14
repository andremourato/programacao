package aula9.ex1;

import java.io.*;
import java.util.*;

public class ScannerAbeirense implements Iterator<String>, Closeable {
	
	private Scanner read;
	
	public ScannerAbeirense(File f) {
		try {
			read = new Scanner(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ScannerAbeirense(String str) {
		read = new Scanner(str);
	}
	
	@Override
	public void close() {
		read.close();
	}

	@Override
	public boolean hasNext() {
		return read.hasNext();
	}

	@Override
	public String next() {
		String word = read.next();
		word = word.replaceAll("v","b");
		word = word.replaceAll("V","B");
		return word;
	}
	
	
	
}
