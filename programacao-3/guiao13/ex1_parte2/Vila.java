package aula13.ex1_parte2;

public class Vila extends Localidade {

	public Vila(String nome, int populacao) {
		super(nome, populacao);
	}

	@Override
	public String toString() {
		return "Vila "+super.toString();
	}
	
}
