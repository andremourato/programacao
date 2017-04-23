package p2utils;

public class LinkedList<E extends Comparable<E>> {

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
   
   public int count(E e){
    return count(e, first);
  }
  
  private int count(E e, Node<E> n){
    if(n == null) return 0;
    if(e.compareTo(n.elem) == 0) return 1 + count(e, n.next);
    return count(e, n.next);
  }
  
  public int indexOf(E e){
    return indexOf(e, 0, first);
  }
  
  private int indexOf(E e,int i, Node<E> n){
    if(e.compareTo(n.elem) == 0) return i;
    return indexOf(e, i + 1, n.next);
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
    return cloneSublist(start, end, 0, first);
  }
  
  private LinkedList<E> cloneSublist(int start, int end, int index, Node<E> n){
    if(n == null) return new LinkedList<E>();
    if(index > end) return new LinkedList<E>(); //Is outside boundaries
    LinkedList<E> lst = cloneSublist(start, end, index + 1, n.next);
    if(start <= index && index < end){ //Is inside boundaries
      lst.addFirst(n.elem);
    }
    return lst;
  }
  
  public LinkedList<E> cloneExceptSublist(int start, int end){
    return cloneExceptSublist(start, end, 0, first);
  }
  
  private LinkedList<E> cloneExceptSublist(int start, int end, int index, Node<E> n){
    if(n == null) return new LinkedList<E>();
    LinkedList<E> lst = cloneExceptSublist(start, end, index + 1, n.next);
    if(start > index || index >= end){
      lst.addFirst(n.elem);
    }
    return lst;
  }
  
  public void removeSublist(int start, int end){
    removeSublist(start, end, 0, first);
  }
  
  private void removeSublist(int start, int end, int index, Node<E> n){
    if(index < start - 1) removeSublist(start, end, index + 1, n.next);
    if(index == start - 1){
      Node<E> node = n;
      int number = end - start + 1;
      do{
        node = node.next;
        number--;
      }while(number > 0);
      n.next = node;
    }
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


