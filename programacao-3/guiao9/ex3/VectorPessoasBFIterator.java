package aula9.ex3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class VectorPessoasBFIterator {
	
	private Pessoa[] pessoas;
	private int size = 0;
	private VectorIterator iterator;
	
	public VectorPessoasBFIterator(int initialSize) {
		pessoas = new Pessoa[initialSize];
		iterator = new VectorIterator();
	}
	
	public VectorPessoasBFIterator() {
		this(5);
	}
	
	public boolean addPessoa(Pessoa p) {
		ensureCapacity(size + 1);
		pessoas[size++] = p;
		return true;
	}
	
	public void ensureCapacity(int minCapacity) {
		int oldCapacity = pessoas.length;
		if (minCapacity > oldCapacity) {
			Object oldData[] = pessoas;
			int newCapacity = (oldCapacity * 3)/2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			pessoas = Arrays.copyOf(pessoas, newCapacity);
		}
	}
	
	public BFIterator iterator() {
		return iterator;
	}
	
	public int totalPessoas() {
		return size;
	}
	
	private class VectorIterator implements BFIterator{
		
		private int pointer = 0;
		
		@Override
		public boolean hasNext() {
			return pointer < size;
		}

		@Override
		public Object next() {
			int i = pointer;
			//In case there are no elements left
			if (i >= size)
				throw new NoSuchElementException();
			pointer = i + 1;
			return (Pessoa) pessoas[i];
		}

		@Override
		public boolean hasPrevious() {
			return pointer >= 0;
		}

		@Override
		public Object previous() {
			int i = pointer;
			if (i < 0)
				throw new NoSuchElementException();
			pointer = i - 1;
			return (Pessoa) pessoas[i];
		}
		
	}
	
}
