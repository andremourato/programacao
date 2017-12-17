package aula13.ex1_parte1;

public abstract class Regiao {
	
	private final String nome;
	private final int populacao;
	
	public Regiao(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}

	public String nome() {
		return nome;
	}
	
	public int populacao() {
		return populacao;
	}
	
}
