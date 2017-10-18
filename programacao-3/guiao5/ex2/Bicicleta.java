package aula5.ex2;

public class Bicicleta extends Veiculo{

	private final double alturaSelim;
	
	public Bicicleta(Color cor, double alturaSelim) {
		super(2, cor);
		this.alturaSelim = alturaSelim;
	}

	public double getAlturaSelim() {
		return alturaSelim;
	}
	
	@Override
	public String toString() {
		return "BICICLETA";
	}

}
