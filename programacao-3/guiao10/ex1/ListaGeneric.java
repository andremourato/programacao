package aula10.ex1;
import java.util.*;

public class ListaGeneric<T>{
	
	//Will pass the generic type to Java's generic linkedlist
	//In this case Java's LinkedList will deal with the casts
	private List<T> elements = new LinkedList<>();
	
	public boolean addElem(T elem) {
		return elements.add(elem);
	}
	
	public boolean removeElem(T elem) {
		return elements.remove(elem);
	}
	
	public int totalElem() {
		return elements.size();
	}
	
	public Iterator iterator() {
		return elements.iterator();
	}
	
}
