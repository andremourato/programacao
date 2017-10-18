package aula5.ex2;

public abstract class Motorizado extends Veiculo{
	
	//Como a cilindrada é diferente para os automóveis e para as motos, cada uma
	//destas 2 classes terá a sua implementação da cilindrada
	private final int ano;
	private final int cilindrada;
	private final int velocidadeMax;
	private final String matricula;
	
	public Motorizado(int numRodas, Color cor, int velocidadeMax, int cilindrada, String matricula, int ano) {
		super(numRodas, cor);
		this.velocidadeMax = velocidadeMax;
		this.matricula = matricula;
		this.cilindrada = cilindrada;
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getVelocidadeMax() {
		return velocidadeMax;
	}

	public String getMatricula() {
		return matricula;
	}
	
}
