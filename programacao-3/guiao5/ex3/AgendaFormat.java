package aula5.ex3;
import java.io.IOException;

public interface AgendaFormat {
	
	public Pessoa[] readFromFile(String filename) throws IOException;
	public void writeToFile(String filename, Pessoa[] pessoas) throws IOException;
}
