package aula13.ex1_parte2;

public class Aldeia extends Localidade {
	
	public Aldeia(String nome, int populacao) {
		super(nome, populacao);
	}

	@Override
	public String toString() {
		return "Aldeia "+super.toString();
	}

	
}
