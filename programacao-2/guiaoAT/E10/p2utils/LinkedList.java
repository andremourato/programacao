package p2utils;

/*Pensei que fosse mais apropriado (e fácil)
 *desenvolver apenas metodos recursivos */

public class LinkedList<E extends Comparable<E>>{

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

      assert !isEmpty() && first().equals(e);
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

      assert !isEmpty() && last().equals(e);
   }
   
   public int count(E e){
	   return count(e, first, 0);
   }
   
   private int count(E e, Node<E> n, int count){
	    if(n == null) return count;
		if(e.compareTo(n.elem) == 0) count++;
		return count(e, n.next, count);
   }
   
   public int indexOf(E e){
		return indexOf(e, first, 0);
   }
   
   private int indexOf(E e, Node<E> n, int index){
		if(n == null) return -1;
		if(e.compareTo(n.elem) == 0) return index;
		return indexOf(e, n.next, index+1);
   }
   
   public LinkedList<E> cloneReplace(E x, E y){
	  return cloneReplace(x, y, first);
   }
   
   private LinkedList<E> cloneReplace(E x, E y, Node<E> n){
	   if(n == null) return new LinkedList<E>();
	   LinkedList<E> lst = cloneReplace(x, y, n.next);
	   if(x.compareTo(n.elem) == 0) lst.addFirst(y);
	   else lst.addFirst(n.elem);
	   return lst;
   }
   
   public LinkedList<E> cloneSublist(int start, int end){
	    assert start <= end;
	    return cloneSublist(start, end, first, new LinkedList<E>());
   }
   
   private LinkedList<E> cloneSublist(int start, int end, Node<E> n, LinkedList<E> lst){
		//Hasn't started yet
		if(start != 0) return cloneSublist(start - 1, end - 1, n.next, lst);
		else{ //Starts
			lst.addLast(n.elem);
			if(end != 1) return cloneSublist(start, end - 1, n.next, lst);
			else return lst;
		}
   }
   
   public LinkedList<E> cloneExceptSublist(int start, int end){
	   assert start <= end;
	   return cloneExceptSublist(start, end, first, new LinkedList<E>());
   }
   
   private LinkedList<E> cloneExceptSublist(int start, int end, Node<E> n, LinkedList<E> lst){
		//Hasn't started yet
		if(n == null) return lst;
		if(start > 0 || end <= 0) lst.addLast(n.elem);
		return cloneExceptSublist(start - 1, end - 1, n.next, lst);
   }
   
   public void removeSublist(int start, int end){
	    assert end >= start;
		removeSublist(start, end, first);
   }
	
	private void removeSublist(int start, int end, Node<E> n){
		if(start > 1) removeSublist(start - 1, end - 1, n.next);
		else {
			Node<E> node = n;
			int length = end - start + 1;
			while(length >= 0){
				if(length == 0) n.next = node;
				node = node.next;
				length--;
			}
		}
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

   public String toString() {
      if (size()==0) 
         return "[ ]";
      String s = "[ " + first.elem.toString();
      if (size()==1) 
         return s + " ]";
      Node<E> n = first.next;
      while (n!=null) {
         s += ("," + n.elem.toString());
         n = n.next;
      }
      return s + " ]";
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

}


