package aula5.ex2;

public final class CarroPolicia extends Automovel implements Policia{

	private boolean sireneLigada;
	
	public CarroPolicia(Color cor, int velocidadeMax, int cilindrada, String matricula, int ano, boolean trancado, boolean sireneLigada) {
		super(cor, velocidadeMax, cilindrada, matricula, ano, trancado);
		this.sireneLigada = sireneLigada;
	}
	
	public boolean isSireneLigada() {
		return sireneLigada;
	}
	
	public void toggleSirene() { //turns the siren OFF in case it's ON, and vice-versa
		sireneLigada = !sireneLigada;
	}
	
	public ServicoEmergencia getTipo(){
		return ServicoEmergencia.PJ;
	}
	
	@Override
	public String toString() {
		return "CARRO POLICIA";
	}
	
}
