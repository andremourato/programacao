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
  /*Removes a specific element*/
  public void remove(E e){
		remove(e, first);
  }

	private void remove(E e, Node<E> n){
		if(n != null && n.next != null){ //to prevent 'NullPointerException'
			if(n.elem == e) first = n.next; //in case the wanted element is the first one
			if(n.next.elem == e) n.next = n.next.next; //removes n.next if it's the wanted element
			remove(e, n.next);
		}
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

  public LinkedList<E> clone(){ 
		return clone(first);
  }
  
  private LinkedList<E> clone(Node<E> n){
		if(n == null) return new LinkedList<E>();
		LinkedList<E> cln = clone(n.next);
		cln.addFirst(n.elem);
		return cln;
  }
  
  public LinkedList<E> reverse(){ //ERROR In this method. NOT WORKING
		return reverse(first);
  }
  
  private LinkedList<E> reverse(Node<E> n){
		if(n == null) return new LinkedList<E>();
		LinkedList<E> rev = reverse(n.next);
		rev.addLast(n.elem);
		return rev;
  }
  
  public E get(int pos){
		return get(pos, first);
  }
  
  private E get(int pos, Node<E> n){
	  if (pos == 0) return n.elem;
	  return get(pos - 1, n.next);
  }
  
  public LinkedList<E> concatenate(LinkedList<E> lst){
		return concatenate(lst.first, clone());
  }
  
  private LinkedList<E> concatenate(Node<E> n, LinkedList<E> conc){
		if(n == null) return conc;
		else conc.addLast(n.elem);
		return concatenate(n.next, conc);
   }
  
}
