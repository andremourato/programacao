package aula13.ex1_parte1;

public class Localidade {

	private final String nome;
	private final int populacao;
	private final TipoLocalidade tipo;
	
	public Localidade(String nome, int populacao, TipoLocalidade tipo) {
		this.nome = nome;
		this.populacao = populacao;
		this.tipo = tipo;
	}
	
	public TipoLocalidade tipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return String.format("%s %s, População: %d",tipo,nome,populacao);
	}
	
}
