public class Element {
	
	public final int elem; //The element
	public int number; // The number of occurences of the element
	
	Element(int elem, int num){
		this.elem = elem;
		number = num;
	}
	
	@Override
	public String toString(){
		return "["+elem+":"+number+"]";
	}
	
	public boolean contains(int e){
		return elem == e;
	}
	
}

