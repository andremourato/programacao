package p2utils;
import java.io.*;

public class SortedList<E extends Comparable<E>> {

  public SortedList() { }

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /**
   * Checks if the list is empty
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";
    return first.elem;
  }

  /**
   * Inserts a new element in the list
   * @param e the element to be inserted
   */
  public void insert(E e) {
    first = insert(first,e);
    size++;
  }
  private Node<E> insert(Node<E> n, E e) {
    if (n==null || e.compareTo(n.elem) < 0)
      return new Node<E>(e,n);
    n.next = insert(n.next,e);
    return n;
  }

  /**
   * Removes the first element in the list
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
  }
  
  /*ADDED METHODS*/
   /************************************************************/
   //Exercício 8.4
	/*RESOLUÇÃO RECURSIVA*/
	public boolean contains(E e){
		return contains(first, e);
	}
	
	private boolean contains(Node<E> n, E e){
		if(n == null) return false; //It reached the end of the list
		if(e.compareTo(n.elem) == 0) return true;//It found the element
		if(e.compareTo(n.elem) < 0) return false;//The list doesn't contain e
		return contains(n.next, e);
	
	}
	/*RESOLUÇÃO ITERATIVA*/
	/*public boolean contains(E e){
		Node<E> n = first;
		boolean found = false;
		while(n != null || e.compareTo(n.elem) >= 0){
			if(e.compareTo(n.elem) == 0) found = true;//It found the element
			if(n.next == null) break;
			n = n.next;
		}
		return found;
	}*/
	
	//Exercício 8.5
	public String toString(){ //METODO ITERATIVO
		Node<E> n = first;
		String str = "[ ";
		while(n != null){
			str += n.elem;
			if(n.next != null) str += ","; 
			n = n.next;
		}
		return str += " ]";
		
	}
	
	public SortedList<E> merge(SortedList<E> lst){//METODO RECURSIVO
		return merge(first, lst);
	}
	
	private SortedList<E> merge(Node<E> n, SortedList<E> lst){
		if(n == null)return lst;
		lst.insert(n.elem);
		return merge(n.next, lst);
	}
  /************************************************************/


  /**
   * Checks if the list is sorted
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    if (size < 2)
      return true;
    return isSorted(first,first.next); 
  }
  private boolean isSorted(Node<E> prev,Node<E> n) {
    if (n == null) return true;
    if (n.elem.compareTo(prev.elem) < 0) return false;
    return isSorted(n,n.next);
  }
  
	public void print(){
		print(first);
	}
	
	private void print(Node<E> n){
		if(n != null){
			System.out.println(n.elem);
			print(n.next);
		}
	}
	
	public void writeToFile(File file) throws IOException{
		writeToFile(first, new PrintWriter(file));
	}
	
	private void writeToFile(Node<E> n, PrintWriter pwf){
		if(n != null){
			pwf.println(n.elem);
			writeToFile(n.next, pwf);
		}
		else pwf.close();
	}

  // private attributes
  private Node<E> first = null;
  private int size = 0;

}
