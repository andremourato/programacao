package aula13.ex1_parte2;

public class Provincia extends Regiao {
	
	private final String governador;
	
	public Provincia(String nome, int populacao, String governador) {
		super(nome, populacao);
		this.governador = governador;
	}
	
	public String getGovernador() {
		return governador;
	}

}
