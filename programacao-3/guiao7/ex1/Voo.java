package aula7.ex1;

public class Voo implements Comparable<Voo> {

	private Hora atraso = new Hora(); //Empty Hora represents that the flight has no delay
	private final Hora partida;
	private final String nome;
	private final String origem;
	private final Companhia companhia;
	
	public Voo(Hora partida, Hora atraso, String nome, String origem, Companhia companhia) {
		if(partida == null || atraso == null || origem == null || companhia == null) throw new NullPointerException("Null element present");
		this.partida = partida;
		this.atraso = atraso;
		this.nome = nome;
		this.origem = origem;
		this.companhia = companhia;
	}
	
	public int delayToMinutes() {
		return atraso.getTotalMinutos();
	}

	public Hora getAtraso() {
		return atraso;
	}

	public Hora getPartida() {
		return partida;
	}

	public String getNome() {
		return nome;
	}

	public String getOrigem() {
		return origem;
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	@Override
	public String toString() {
		return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\t%s",  partida.toString(),
														nome.toString(),
														companhia.toString(),
														origem.toString(),
														Hora.isHourZero(atraso) ? "" : atraso.toString(),
														Hora.isHourZero(atraso) ? "" : "Previsto: "+Hora.horaPrevista(partida,atraso).toString());
	}

	@Override
	public int compareTo(Voo v) {
		return delayToMinutes()-v.delayToMinutes();
	}
	
}
