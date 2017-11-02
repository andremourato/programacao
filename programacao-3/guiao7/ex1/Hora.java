package aula7.ex1;

public class Hora implements Comparable<Hora>{
	
	private static final Hora hourZero = new Hora();
	private final int totalMinutos;
	
	public Hora(int totalMinutos) {
		this.totalMinutos = totalMinutos;
	}
	
	public Hora() {
		this(0,0);
	}
	
	public Hora(String str) {
		this(str,":");
	}
	
	public Hora(String str, String regex) {
		this(Integer.parseInt(str.split(regex)[0]),Integer.parseInt(str.split(regex)[1]));
	}
	
	public Hora(int hora, int minutos) {
		this(hora * 60 + minutos);
	}
	
	public static Hora horaPrevista(Hora h1, Hora h2) {
		int somaTotalMinutos = h1.getTotalMinutos() + h2.getTotalMinutos();
		int newHoras = somaTotalMinutos/60;
		int newMinutos = somaTotalMinutos%60;
		if(newHoras > 23) newHoras = newHoras - 24;
		return new Hora(newHoras, newMinutos);
	}
	
	public int getHora() {
		return totalMinutos/60;
	}

	public int getMinutos() {
		return totalMinutos%60;
	}
	
	public int getTotalMinutos() {
		return totalMinutos;
	}
	
	public static boolean isHourZero(Hora h) {
		return hourZero.equals(h);
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", getHora(), getMinutos());
	}

	@Override
	public int compareTo(Hora h) {
		return this.getTotalMinutos() - h.getTotalMinutos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + totalMinutos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hora other = (Hora) obj;
		if (totalMinutos != other.totalMinutos)
			return false;
		return true;
	}
	
	
}
