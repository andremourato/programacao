/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package aula3;

public class Condutor extends Pessoa{
	
	private final Carta carta;
	
	public Condutor(String nome, int cc, Data nasc, Carta c) {
		super(nome,cc,nasc);
		carta = c;
	}
	
	public Carta carta() { return carta; }
	public String toString() {
		return super.toString() + ", Carta: "+ carta;
	}
}
