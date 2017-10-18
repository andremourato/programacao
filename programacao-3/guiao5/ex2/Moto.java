package aula5.ex2;

public class Moto extends Motorizado{

	private boolean atrelado;
	
	public Moto(Color cor, int velocidadeMax, int cilindrada, String matricula, int ano, boolean atrelado) {
		super(2, cor, velocidadeMax, cilindrada, matricula, ano);
		this.atrelado = atrelado;
	}

	public boolean hasAtrelado() {
		return atrelado;
	}
	
	@Override
	public String toString() {
		return "MOTO";
	}
	
}
