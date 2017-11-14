package aula9.ex1;

import java.io.File;

public class Test {
	
	public static void main(String[] args) {
		
		ScannerAbeirense scan = null;
		if(args.length == 0) {
			try {
				scan = new ScannerAbeirense(new File("teste_scanner.txt"));
			}catch(Exception e) {
				System.err.println("Não foi possível abrir o ficheiro!");
			}
			
		}else {
			scan = new ScannerAbeirense(args[0]);
		}
		
		while(scan.hasNext()) {
			System.out.print(scan.next()+" ");
		}
		scan.close();
	}
	
}
