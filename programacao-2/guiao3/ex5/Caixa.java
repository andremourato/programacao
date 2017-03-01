import java.util.*;

public class Caixa {
	
	private int numMoedas = 0;
	private long moedas[] = new long[0];
	
	private void adicionaMoeda(long moeda){ 
		
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
	
	private void reduceArray(int numRetirar){ //reduz o array com 'numRetirar' elementos
		
		long[] tempMoedas = new long[numMoedas];
		System.arraycopy(moedas, numRetirar, tempMoedas, 0, numMoedas); //TODO COMPLETAR!
		moedas = tempMoedas;
	
	}
	
	private void mostrarMoedasARetirar(int numRetirar){
		
		for(int i=0;i<numRetirar;i++){
			if(i < numRetirar-1){
				System.out.print(moedas[i]+", ");
			}else System.out.print(moedas[i]);
		}
		System.out.println();
	}
	
	public void adicionarMoedas(){ //adiciona uma quantidade de moedas
		
		Scanner read = new Scanner(System.in);
		long moeda ;
		System.out.print("Moeda: ");
		do{
			moeda = read.nextLong();
			if(moeda != 0) adicionaMoeda(moeda);
		}while(moeda != 0);
	}
	
	public void retirarMoedas(long valorMin){ //retira uma quantidade de moedas
		
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
		reduceArray(numRetirar);
		
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
