package aula5.ex2;

public abstract class Veiculo {

	static int ID_VEICULO = 1;
	private final int id;
	private final int numRodas;
	private Color cor;
	
	public Veiculo(int numRodas, Color cor) {
		this.numRodas = numRodas;
		this.cor = cor;
		id = ID_VEICULO++;
	}
	public int getNumRodas() {
		return numRodas;
	}
	public Color getCor() {
		return cor;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "VEICULO";
	}

}
