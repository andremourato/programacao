package aula13.ex1_parte1;

public class Estado extends Regiao {

	private final Localidade capital;
	
	public Estado(String nome, int populacao, Localidade capital) {
		super(nome,populacao);
		this.capital = capital;
	}
	
	public Localidade getCapital() {
		return capital;
	}
	
}
