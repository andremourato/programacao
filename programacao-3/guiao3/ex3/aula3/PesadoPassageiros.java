/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;

public class PesadoPassageiros extends Veiculo{
	
	private final String[] paragens = {"Viseu", "Macedo de Cavaleiros", "Mirandela", "Vila Real", "Porto", "Aveiro", "Lisboa", "Beja"};
	
	public PesadoPassageiros(Condutor c) {
		//Os valores aqui introduzidos não representam valores reais
		super(c,20,50,300,5000,new Carta("D"));
	}
	
	//Represents a BUS STOP
	//An array is passed as argument representing the passengers that will get off the bus
	public void saidaPassageiros(Pessoa[] pessoas) throws Exception{ 
		for(Pessoa pessoa : pessoas) {
			removePassageiro(pessoa);
		}
	}
	
	public void anunciarParagem(String paragem) throws Exception {
		//Verifica se a paragem passada como argumento é válida
		for(String p : paragens) {
			if(p.equals(paragem)) {
				System.out.println("Proxima paragem: "+paragem);
				return;
			}
		}
		throw new Exception("A paragem '"+paragem+"' nao existe!");
	}

	@Override
	public String toString() {
		return "PESADO PASSAGEIROS";
	}
	
	@Override
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+super.condutor().nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+super.lotacao()+
				"\nCilindrada -> "+cilindrada()+
				"\nPotencia -> "+potencia()+
				"\npesoBruto -> "+pesoBruto()+"\n";
	}
	
}
