/*
 * Andr� Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;

public class Motociclo extends Veiculo{
	
	private boolean atrelado;
	
	public Motociclo(Condutor c, boolean atrelado) {
		//Veiculo(Condutor c, int lot, double cil, double pot, double peso)
		//Cada uma das classes: Motociclo, Ligeiro, PesadoMercadoria e PesadoPassageiros
		//cria um novo ve�culo com os valores apropriados de lota��o, cilindrada, pot�ncia, peso bruto e carta
		//Os valores aqui introduzidos n�o representam valores reais
		super(c,atrelado?2:1,125,11,3000,new Carta("A"));
		//Se tiver atrelado a sua lota��o � 2, caso contr�rio � 1
		this.atrelado = atrelado;
	}
	
	public Motociclo(Condutor c) {
		this(c,false);
	}
	
	public boolean temAtrelado() {
		return atrelado;
	}
	
	@Override
	public String toString() {
		return "MOTOCICLO";
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
				"\nAtrelado - > "+(atrelado?"Sim":"N�o")+"\n";
	}
}
