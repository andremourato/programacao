package aula4_e1;

public class Estudante extends Pessoa{
	
	private static int currentNMEC = 100;
	private final int nmec;
	private final Data dataInscr;
	
	public Estudante(String nome, int cc, Data dataNascimento, Data dataInscr){
		super(nome,cc,dataNascimento);
		this.nmec = currentNMEC++;
		this.dataInscr = dataInscr;
	}
	
	public Estudante(String nome, int cc, Data dataNascimento){
		this(nome, cc, dataNascimento, new Data());
	}
	
	public int nMec() { return nmec; }
	public Data dataInscr() { return dataInscr; }
	
	@Override
	public String toString() {
		return super.toString() + ", NMec: " + nmec + ", inscrito em Data: " + dataInscr;	
	}
	
	
}
