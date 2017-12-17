package aula13.ex1_parte2;

public class Localidade {

	private final String nome;
	private final int populacao;
	
	public Localidade(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}
	
	@Override
	public String toString() {
		return String.format("%s, População: %d",nome,populacao);
	}
	
}
