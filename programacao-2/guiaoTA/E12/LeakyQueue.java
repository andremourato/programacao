/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos.
 * Quando a fila está preenchida (N elementos) a inserção de um novo número
 * implica a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue
{
	LeakyQueue(int N){
		array = new double[N];
	}
	
	public void print(){
		assert !isEmpty();
		for(int i = size - 1; i >= 0; i--){
			System.out.printf("%4.1f ", array[i]);
		}
		
	}
	
	public double minimum(){
		assert !isEmpty();
		double min = array[0];
		for(int i = 1; i < size; i++){
			if(array[i] < min) min = array[i];
		}
		return min;
	}
	
	public void in(double n){
		if(!isFull()){
			size++;
			System.arraycopy(array, 0, array, 1, array.length - 1);
			array[0] = n;
		}
		else{
			System.arraycopy(array, 0, array, 1, array.length - 1);
			array[0] = n;
		}
	}
	
	public void out(){
		assert !isEmpty();
		size--;
		
	}
	
	public boolean isFull(){
		return size == array.length;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){ return size; }
	
	private int size = 0;
	private double[] array;
}

