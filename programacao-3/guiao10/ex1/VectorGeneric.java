package aula10.ex1;

import java.util.*;

public class VectorGeneric<T> implements Iterable<T> {
	
	//In this case VectorGeneric will deal with the generic type
	//Since there cannot be generic type arrays, an Object[] is used instead
	private Object[] elements;
	private int size = 0;
	private VectorIterator iterator;
	
	public VectorGeneric(int initialSize) {
		elements = new Object[initialSize];
		iterator = new VectorIterator();
	}
	
	public VectorGeneric() {
		this(5);
	}
	
	public boolean addElem(T elem) {
		ensureCapacity(size + 1);
		elements[size++] = elem;
		return true;
	}
	
	public boolean removeElem(T elem) {
		if(elem == null) return false;
		for(int i = 0; i < elements.length; i++) {
			if(elements[i].equals(elem)) {
				return removeElemByIndex(i);
			}
		}
		return false;
	}
	
	private boolean removeElemByIndex(int index) {
		int num = size - 1 - index;
		if (num > 0) System.arraycopy(elements, index+1, elements, index,num);
		elements[--size] = null;
		return true;
	}
	
	public void ensureCapacity(int minCapacity) {
		int oldCapacity = elements.length;
		if (minCapacity > oldCapacity) {
			Object oldData[] = elements;
			int newCapacity = (oldCapacity * 3)/2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
	
	public int totalElem() {
		return size;
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class VectorIterator implements Iterator<T>{
		
		int pointer = 0;
		
		@Override
		public boolean hasNext() {
			return pointer < size;
		}

		@Override
		public T next() {
			int i = pointer;
			//In case there are no elements left
			if (i >= size)
				throw new NoSuchElementException();
			pointer = i + 1;
			return (T) elements[i];
		}
		
	}
}
