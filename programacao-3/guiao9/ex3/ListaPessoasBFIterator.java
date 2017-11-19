package aula9.ex3;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaPessoasBFIterator {

	private List<Pessoa> pessoas = new LinkedList<>();
	private ListaPessoasIterator iterator = new ListaPessoasIterator();
	
	public boolean addPessoa(Pessoa p) {
		return pessoas.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		return pessoas.remove(p);
	}
	
	public int totalPessoas() {
		return pessoas.size();
	}
	
	public BFIterator iterator() {
		return iterator;
	}
	
	private class ListaPessoasIterator implements BFIterator{
		
		private int pointer = 0;
		
		public boolean hasPrevious() {
			return pointer >= 0;
		}
		
		public Pessoa previous() {
			int i = pointer;
			if(i < 0) 
				throw new NoSuchElementException();
			pointer = i - 1;
			return pessoas.get(i);
		}
		
		public boolean hasNext() {
			return pointer < pessoas.size();
		}
		
		public Pessoa next() {
			int i = pointer;
			if(i >= pessoas.size())
				throw new NoSuchElementException();
			pointer = i + 1;
			return pessoas.get(i);
		}
		
	}
}
