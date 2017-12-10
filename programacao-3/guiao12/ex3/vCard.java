package aula12.ex3;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vCard implements Plugin{

	public Pessoa[] readFromFile(String filename) throws IOException{
		Scanner read = new Scanner(new File(filename));
		read.nextLine();
		List<Pessoa> lista = new ArrayList<>();
		while(read.hasNextLine()) {
			String[] data = read.nextLine().split("#");
			String nome = data[1];
			int contacto = Integer.parseInt(data[2]);
			String[] date = data[3].split("/");
			lista.add(new Pessoa(nome,new Data(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),contacto));
		}
		read.close();
		return lista.toArray(new Pessoa[0]);
	}
	
	public void writeToFile(String filename, Pessoa[] pessoas) throws IOException{
		PrintWriter pwf = new PrintWriter(new File(filename));
		pwf.println("vCard");
		for(Pessoa pessoa : pessoas) {
			pwf.println("#"+pessoa.toString("#"));
		}
		pwf.close();
	}
	
	@Override
	public String toString() {
		return "vCard";
	}

}
