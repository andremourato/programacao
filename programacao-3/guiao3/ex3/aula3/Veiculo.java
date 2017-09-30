/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;
import java.util.ArrayList;

public class Veiculo {
	
	private Condutor condutor;
	private Carta cartaNecessaria;
	private ArrayList<Pessoa> passageiros; //Everyone except the driver
	private final int lotacao;
	private final double cilindrada;
	private final double potencia;
	private final double pesoBruto;
	
	public Veiculo(Condutor c, int lot, double cil, double pot, double peso, Carta carta) {
		condutor = c;
		lotacao = lot;
		cartaNecessaria = carta;
		cilindrada = cil;
		potencia = pot;
		pesoBruto = peso;
		passageiros = new ArrayList<>();
	}

	//Aceita carta invalida, mas retorna 'false' caso o condutor nao tenha a carta apropriada
	public boolean cartaValidaCondutor() { //Checks if the driver has an appropriate license for the vehicle he is driving
		return cartaNecessaria.equals(condutor.carta());
	}
	
	public void addPassageiro(Pessoa p) throws Exception{
		if(numPassageiros() < lotacao - 1) {
			passageiros.add(p);
		}else {
			throw new Exception("Veiculo cheio. Nao e possivel adicionar passageiros");
		}
	}
	
	//Seria possível fazer mais verificações, como por exemplo verificar se a pessoa existe
		//Para este exercício é considerado que a pessoa passada como argumento já é um passageiro
	public void removePassageiro(Pessoa pessoa) throws Exception{
		if(numPassageiros() > 0) {
			passageiros.remove(pessoa);
		}else {
			throw new Exception("Veiculo vazio. Nao e possivel remover passageiros");
		}
	}
	
	public void removePassageiro(int cc) throws Exception{
		if(numPassageiros() > 0) {
			for(Pessoa passageiro : passageiros.toArray(new Pessoa[0])) {
				if(passageiro.cc == cc) {
					passageiros.remove(passageiro);
				}
			}
		}else {
			throw new Exception("Veiculo vazio. Nao e possivel remover passageiros");
		}
	}
	
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+condutor.nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+lotacao+
				"\nCilindrada -> "+cilindrada()+
				"\nPotencia -> "+potencia()+
				"\npesoBruto -> "+pesoBruto()+"\n";
	}
	
	@Override
	public String toString() {
		return "VEICULO";
	}
	
	public int lotacao() {
		return lotacao;
	}
	
	//Número de passageiros sem contar com o condutor
	public int numPassageiros() {
		return passageiros.size();
	}
	
	public Condutor condutor() {
		return condutor;
	}
	
	public void mudarCondutor(Condutor p) {
		condutor = p;
	}

	public double cilindrada() {
		return cilindrada;
	}

	public double potencia() {
		return potencia;
	}

	public double pesoBruto() {
		return pesoBruto;
	}
}
