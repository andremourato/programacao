package aula5.ex3;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Nokia implements AgendaFormat{
	
	public Pessoa[] readFromFile(String filename) throws IOException{
		Scanner read = new Scanner(new File(filename));
		read.nextLine();
		List<Pessoa> lista = new ArrayList<>();
		while(read.hasNextLine()) {
			String nome = read.nextLine();
			int contacto = Integer.parseInt(read.nextLine());
			String[] data = read.nextLine().split("/");
			if(read.hasNextLine()) read.nextLine();
			lista.add(new Pessoa(nome,new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])),contacto));
		}
		read.close();
		return lista.toArray(new Pessoa[0]);
	}

	public void writeToFile(String filename, Pessoa[] pessoas) throws IOException{
		PrintWriter pwf = new PrintWriter(new File(filename));
		pwf.println("Nokia");
		for(Pessoa pessoa : pessoas) {
			pwf.println(pessoa.nome());
			pwf.println(pessoa.contacto());
			pwf.println(pessoa.dataNasc());
			pwf.println();
		}
		pwf.close();
	}
	
}
