package p2utils;

public class SortedArray<E extends Comparable<E>> {
	
	public SortedArray(int length) {
		array = (E[]) new Comparable[length];
	}

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /**
   * Checks if the list is empty
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  public boolean isFull(){return size == array.length;}
  /**
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";
    return array[0];
  }

  /**
   * Inserts a new element in the list
   * @param e the element to be inserted
   */
  public void insert(E e) {
	if(isFull()){
		System.out.println("Array is full. Cannot insert more elements.");
		return;
	}
	assert !isFull();
	//if it isn't full
    for(int i = 0; i <= size; i++) {	
		if(array[i] == null) {
			array[i] = e;
			size++;
			break;
		}
		if(e.compareTo(array[i]) <= 0){
			for(int j = size; j > i; j--){
				array[j] = array[j-1];
			}
			array[i] = e;
			size++;
			break;
		}
	}
  }

  /**
   * Removes the first element in the list
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    for(int i = 0; i < size - 1; i++){
		array[i+1] = array[i];
	}
    size--;
  }
	public boolean contains(E e){
		
		boolean found = false;
		for(int i = 0; i < size; i++){
			if(e.compareTo(array[i]) < 0) break;
			if(e.compareTo(array[i]) == 0){
				found = true;
				break;
			}
		}
		return found;
	}
	
	public String toString(){
		
		String str = "[ ";
		for(int i = 0; i < size; i++){
			str += array[i];
			if(i < size -1) str += ",";
		}
		return str += " ]";
		
	}
	
	public SortedArray<E> merge(SortedArray<E> lst){//METODO RECURSIVO
		SortedArray<E> newArr = new SortedArray(array.length + lst.array.length);
		for(E elem : array){
			if(elem != null) newArr.insert(elem);
		}
		for(E elem : lst.array){
			if(elem != null) newArr.insert(elem);
		}
		return newArr;
	}
	
  /**
   * Checks if the list is sorted
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    boolean sorted = true;
    if(size < 2) return true;
    for(int i = 0; i < size - 1; i++){
		if(array[i+1].compareTo(array[i]) < 0){
			sorted = false;
			break;
		}
	}
	return sorted;
  }

  // private attributes
  private E[] array;
  private int size = 0;
	
}

