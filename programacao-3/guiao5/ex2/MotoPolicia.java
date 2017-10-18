package aula5.ex2;

public final class MotoPolicia extends Moto implements Policia{

	public MotoPolicia(Color cor, int velocidadeMax, int cilindrada, String matricula, int ano, boolean atrelado) {
		super(cor, velocidadeMax, cilindrada, matricula, ano, atrelado);
	}

	public ServicoEmergencia getTipo(){
		return ServicoEmergencia.PSP;
	}
	
	@Override
	public String toString() {
		return "MOTO POLICIA";
	}
	
}
