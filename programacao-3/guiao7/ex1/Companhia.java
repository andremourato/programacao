package aula7.ex1;

public class Companhia{
	
	private final String sigla;
	private final String nome;
	
	public Companhia(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
