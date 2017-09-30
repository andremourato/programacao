/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;

public class Carta {

	private final String tipo;
	
	public Carta(String t) {
		if(!t.equals("A") && !t.equals("B") && !t.equals("C") && !t.equals("D")) throw new IllegalArgumentException("Tipo errado para a carta!");
		tipo = t;
	}
	
	public boolean equals(Carta c) {
		return tipo.equals(c.tipo);
	}
	
	public boolean equals(String t) {
		return tipo.equals(t);
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	
}
