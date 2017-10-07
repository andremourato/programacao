package aula4_e1;

public class Bolseiro extends Estudante{

	private int bolsa;
	
	public Bolseiro(String nome, int cc, Data dataNascimento, Data dataInscr){
		super(nome, cc, dataNascimento, dataInscr);
	}
	
	public Bolseiro(String nome, int cc, Data dataNascimento){
		super(nome, cc, dataNascimento);
	}

	public int bolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Bolsa: " + bolsa;
	}
	
}
