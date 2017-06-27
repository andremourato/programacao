/**
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.

Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

public class Train {

	private Wagon first = null;
	private Wagon last = null;
	private double wagonCapacity;
	private double trainCapacity;
	private double totalWeight;
	private int numWagons = 0;

	public Train(double wagonCap, double trainCap){
		wagonCapacity = wagonCap;
		trainCapacity = trainCap;
		
	}

	public void addWagon(double loadSize){
		assert acceptsCargo(loadSize);
		Wagon w = new Wagon(loadSize);
		if(isEmpty())
			first = w;
		else{
			last.next = w;
			w.prev = last;
		}
		last = w;
		totalWeight += loadSize;
		numWagons++;
	}
	
	public double removeWagon(){
		assert !isEmpty();
		totalWeight -= last.weight;
		double weight = last.weight;
		last.prev.next = null;
		last = last.prev;
		numWagons--;
		return weight;
	}
	
	public int unload(double load){
		assert !isEmpty();
		assert totalWeight >= load;
		Wagon w = last;
		int removed = 0;
		while(load > 0 && w != null){
			//Removes the wagon if it still needs to remove more weight
			if(load > w.weight){
				removeWagon();
				load -= w.weight;
				removed++;
			}
			else{
				w.weight -= load;
				if(w.weight == 0){
					removeWagon();
					removed++;
				}
				load = 0;
			}
				
			w = w.prev;
		}
		return removed;
		
	}
	
	public boolean acceptsCargo(double c){
		return totalWeight + c <= trainCapacity;
	}
		
	public boolean isEmpty(){
		return numWagons == 0;
	}
	
	public double[] list(){
		double[] weights = new double[numWagons];
		list(first, weights, 0);
		return weights;
	}
	
	private void list(Wagon w, double[] array, int i){
		if(i < array.length){
			array[i] = w.weight;
			list(w.next, array, i + 1);
		}
	}
	
	public double totalCargo(){
		return totalWeight;
	}
	
	public int size(){
		return numWagons;
	}

}

