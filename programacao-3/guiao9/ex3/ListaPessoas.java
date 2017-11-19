package aula9.ex3;
import java.util.*;

public class ListaPessoas {
	
	private List<Pessoa> pessoas = new LinkedList<>();
	
	public boolean addPessoa(Pessoa p) {
		return pessoas.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		return pessoas.remove(p);
	}
	
	public int size() {
		return pessoas.size();
	}
	
	public Iterator iterator() {
		return pessoas.iterator();
	}
	
}
