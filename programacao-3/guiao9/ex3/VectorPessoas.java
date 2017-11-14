package aula9.ex3;

import java.util.*;

public class VectorPessoas {
	
	private Pessoa[] pessoas;
	private int size = 0;
	private VectorIterator iterator;
	
	public VectorPessoas(int initialSize) {
		pessoas = new Pessoa[initialSize];
		iterator = new VectorIterator();
	}
	
	public VectorPessoas() {
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
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class VectorIterator implements Iterator{
		
		int pointer = 0;
		
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
		
	}
}
