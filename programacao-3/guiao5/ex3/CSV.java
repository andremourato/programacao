package aula5.ex3;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV implements AgendaFormat {
	
	public Pessoa[] readFromFile(String filename) throws IOException {
		Scanner read = new Scanner(new File(filename));
		read.nextLine();
		List<Pessoa> lista = new ArrayList<>();
		while(read.hasNextLine()) {
			String[] data = read.nextLine().split("\t");
			String nome = data[0];
			int contacto = Integer.parseInt(data[1]);
			String[] date = data[2].split("/");
			lista.add(new Pessoa(nome,new Data(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),contacto));
		}
		read.close();
		return lista.toArray(new Pessoa[0]);
	}
	
	public void writeToFile(String filename, Pessoa[] pessoas) throws IOException{
		PrintWriter pwf = new PrintWriter(new File(filename));
		pwf.println("CSV");
		for(Pessoa pessoa : pessoas) {
			pwf.println(pessoa.toString("\t"));
		}
		pwf.close();
	}
}
