import java.util.*;
/**
 * Complete este módulo de forma a que o programa principal funcione
 * devidamente.
 * 
 * Uma CompressedQueue é uma fila, mas onde entradas com o mesmo valor são
 * comprimidas para um único elemento da fila contendo o valor e o número de
 * repetições.
 * 
 * Além disto e dos métodos usuais, tem também métodos adicionais:
 * 
 * peekCount()
 *   Devolve o número de repetições do valor existente na frente da fila.
 * 
 * maxDiff()
 *   Indica qual o maior "salto" (em valor absoluto) entre elementos
 *   consecutivos da fila.
 * 
 * minDiff()
 *   Indica qual o menor "salto" (em valor absoluto) entre elementos
 *   consecutivos da fila.
 * 
 * toString()
 *   Devolve uma string com os elementos da fila (entre {}), por ordem, em cada
 *   elemento é descrito pelo par valor e repetições (entre []) e cada elemento
 *   é por vírgulas.
 * 
 **/

public class CompressedQueue {
	
	List<Element> queue = new ArrayList<>();
	
	public void in(int e){
		Element[] array = toArray();
		boolean found = false;
		//Checks if the element already exists
		for(int i = 0; i < array.length && !found; i++){
			if(array[i].contains(e)){
				array[i].number++;
				found = true;
			}
		}
		if(!found)
			queue.add(new Element(e,1));
	}
	
	public void out(){
		queue.remove(0);
	}
	
	public int size(){
		return queue.size();
	}
	
	public boolean empty(){
		return queue.size() == 0;
	}
	
	public int peek(){
		return queue.get(0).elem;
	}
	
	public int peekCount(){
		return queue.get(0).number;
	}
	
	public int maxDiff(){
		Element[] elems = this.toArray();
		int max = -1;
		for(int i = 1; i < elems.length; i++){
			int diff = Math.abs(elems[i].elem-elems[i-1].elem);
			if(diff > max)
				max = diff;
		}
		return max;
	}
	
	public int minDiff(){
		Element[] elems = this.toArray();
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < elems.length; i++){
			int diff = Math.abs(elems[i].elem-elems[i-1].elem);
			if(diff < min)
				min = diff;
		}
		return min;
	}
	
	public String toString(){
		return toString("{",",","}");
	}
	
	public String toString(String left, String mid, String right){
		Element[] elems = this.toArray();
		String str = "";
		for(int i = 0; i < elems.length; i++){
			str += elems[i];
			if(i != elems.length-1)
				str += mid;
		}
		return left+str+right;
	}
	
	public void clear(){
		queue.clear();
	}
	
	private Element[] toArray(){
		return queue.toArray(new Element[0]);
	}

}

