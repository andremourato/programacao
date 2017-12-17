package aula13.ex1_parte2;

public class Cidade extends Localidade {

	public Cidade(String nome, int populacao) {
		super(nome, populacao);
	}

	@Override
	public String toString() {
		return "Cidade "+super.toString();
	}
	
}
