package p2utils;

public class LinkedList<E> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /**
   * {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

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
   * @return  Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /**
   * Adds a new element to the start of the list
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /**
   * Adds a new element to the end of the list
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /**
   * Removes the first element in the list
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /**
   * Removes all elements
   */
  public void clear() {
    first = last = null;
    size = 0;
  }


  /** Prints all elements, one per line. */
  public void print() {
    print(first);
  }
  private void print(Node<E> n) {
    if (n != null) {
      System.out.println(n.elem);
      print(n.next);
    }
  }
  
  /***************************************/
  
	public LinkedList<E> clone(){
		return clone(first);
	}
	
	private LinkedList<E> clone(Node<E> n){
		if(n == null) return new LinkedList<E>();
		LinkedList<E> lst = clone(n.next);
		lst.addFirst(n.elem);
		return lst;
	}
  
	//Same as clone() but it uses addLast
	public LinkedList<E> reverse(){
			return reverse(first);
	}
  
	private LinkedList<E> reverse(Node<E> n){
		if(n == null) return new LinkedList<E>();
		LinkedList<E> lst = reverse(n.next);
		lst.addLast(n.elem);
		return lst;
	}
	
	public E get(int pos){
		assert 0 <= pos && pos < size();
		return get(pos, first);
	}
	
	private E get(int pos, Node<E> n){
		if(pos == 0) return n.elem;
		return get(pos - 1, n.next);
	}
	
	public LinkedList<E> concatenate(LinkedList<E> lst){
		return concatenate(clone(), lst.first);
	}
	
	private LinkedList<E> concatenate(LinkedList<E> conc, Node<E> n){
		if(n == null) return conc;
		conc.addLast(n.elem);
		return concatenate(conc, n.next);
	}
	
	public void remove(E e){
		remove(e, first);
	}
  
	private void remove(E e, Node<E> n){
		if(e.equals(n.elem)) first = n.next;
		if(e.equals(n.next.elem)) n.next = n.next.next;
		else remove(e, n.next);
	}
  
  /***************************************/

  /**
   * Checks if the given element exists in the list
   * @param e an element
   * @return {@code true} if the element exists and {@code false} otherwise
   */
  public boolean contains(E e) { 
    return contains(first,e);
  }
  private boolean contains(Node<E> n,E e) {
    if (n == null) return false;
    if (n.elem==null) return e==null; //dispensável, se impedirmos elem==null
    if (n.elem.equals(e)) return true; 
    return contains(n.next,e);
  }

  public String inString(){
	 if(isEmpty()) return "[]";
	 return "[" + inString(first) + "]";
  }
  
  private String inString(Node<E> n){
	 if(n.next == null) return String.valueOf(n.elem);
	 return String.valueOf(n.elem) + ", " + inString(n.next);
	 
  }
  

}
