/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;

public class Ligeiro extends Veiculo{
	
	private String cor;
	
	public Ligeiro(Condutor c, String cor) {
		//Veiculo(Condutor c, int lot, double cil, double pot, double peso)
		//Os valores aqui introduzidos não representam valores reais
		super(c,5,30,400,4000, new Carta("B"));
		this.cor = cor;
	}
	
	public void pintarCarro(String novaCor) {
		cor = novaCor;
	}
	
	public String cor() {
		return cor;
	}
	
	@Override
	public String toString() {
		return "LIGEIRO";
	}
	
	@Override
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+super.condutor().nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+super.lotacao()+
				"\nCilindrada -> "+cilindrada()+
				"\nPotencia -> "+potencia()+
				"\npesoBruto -> "+pesoBruto()+
				"\nCor - > "+cor+"\n";
	}
}
