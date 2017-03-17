import java.util.*;

public class Caixa {
	
	private int numMoedas = 0;
	private long moedas[] = new long[0];
	
	private void adicionaMoeda(long moeda){ 
		
		assert moedaValida(moeda);
		numMoedas++;
		if(moedas.length==0) moedas = new long[1];
		else extendArray();
		moedas[numMoedas-1] = moeda;
		
	}
	
	private void extendArray(){ //expande o array de moedas com +1 elemento
		
		long[] tempMoedas = new long[numMoedas];
		System.arraycopy(moedas, 0, tempMoedas, 0, numMoedas-1);
		moedas = tempMoedas;
	
	}
	
	private long[] reduceArray(int numRetirar){ //reduz o array com 'numRetirar' elementos
		
		long[] tempMoedas = new long[numMoedas];
		System.arraycopy(moedas, numRetirar, tempMoedas, 0, numMoedas);
		return tempMoedas;
	
	}
	
	private void mostrarMoedasARetirar(int numRetirar){
		
		for(int i=0;i<numRetirar;i++){
			if(i < numRetirar-1){
				System.out.print(moedas[i]+", ");
			}else System.out.print(moedas[i]);
		}
		System.out.println();
	}
	
	private long[] retirarMoedas(long valorMin){ //retira uma quantidade de moedas
		
		long sum = 0;
		int numRetirar = 0;
		for(int i=0; sum < valorMin; i++){
			if(sum < valorMin){
				sum += moedas[i];
				numRetirar++;
			}
		}
		numMoedas -= numRetirar;
		mostrarMoedasARetirar(numRetirar);
		return reduceArray(numRetirar);
	}
	
	private boolean moedaValida(long moeda){
		if(moeda > 0){
			if(moeda == 0 || moeda == 2 || moeda == 5) return true;
			if(isPowerOf(1, moeda) || isPowerOf(2, moeda) || isPowerOf(5, moeda)) return true;
		}else return false;
		return false;
	}
	
	private boolean isPowerOf(int n, long input) { //verifica-se se input é potencia de 10 vezes n
        if (input % n != 0 || input == 0) return false;
        if (input == n) return true;
        return isPowerOf(n, input/10);
    }

	
	public void adicionarMoedas(){ //adiciona uma quantidade de moedas
		
		Scanner read = new Scanner(System.in);
		long moeda ;
		do{
			System.out.print("Moeda: ");
			moeda = read.nextLong();
			if(moedaValida(moeda)) adicionaMoeda(moeda);
			else System.out.println("Introduza um valor valido de moedas.");
		}while(moeda != 0);
	}
	
	public void updateMoedas(long valorMin){
		moedas = retirarMoedas(valorMin);
	}
	
	public long total(){
		long total = 0;
		for(int i=0;i<moedas.length;i++){
			total += moedas[i];
		}
		return total;
	}
	
	public long[] moedas(){
		return moedas;
	}
}
