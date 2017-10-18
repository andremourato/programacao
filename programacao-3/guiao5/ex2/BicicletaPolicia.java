package aula5.ex2;

public final class BicicletaPolicia extends Bicicleta implements Policia{

	public BicicletaPolicia(Color cor, double alturaSelim) {
		super(cor, alturaSelim);
	}

	public ServicoEmergencia getTipo(){
		return ServicoEmergencia.PSP;
	}
	
	@Override
	public String toString() {
		return "BICICLETA POLICIA";
	}
	
}