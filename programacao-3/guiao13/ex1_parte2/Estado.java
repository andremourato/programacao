package aula13.ex1_parte2;

public class Estado extends Regiao {

	private final Localidade capital;
	
	public Estado(String nome, int populacao, Cidade capital) {
		super(nome,populacao);
		this.capital = capital;
	}
	
	public Localidade getCapital() {
		return capital;
	}
	
}
