package aula5.ex2;

public class Automovel extends Motorizado{
	
	private boolean trancado;
	
	public Automovel(Color cor, int velocidadeMax, int cilindrada, String matricula, int ano, boolean trancado) {
		super(4, cor, velocidadeMax, cilindrada, matricula, ano);
		this.trancado = trancado;
	}
	
	public boolean isTrancado() {
		return trancado;
	}
	
	@Override
	public String toString() {
		return "AUTOMOVEL";
	}
	
}
