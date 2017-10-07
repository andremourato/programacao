package aula4_e1;

public class Professor extends Pessoa{
	
	private static int NUM_FUNC = 1;
	private final int nfunc;
	private final Data dataAdmissao;
	
	public Professor(String nome, int cc, Data nasc) {
		super(nome, cc, nasc);
		this.nfunc = NUM_FUNC++;
		this.dataAdmissao = new Data(); //Data atual
	}
	
	public String toString() {
		return super.toString() + ", nMec: "+nfunc + ", Admitido em Data: "+dataAdmissao;
	}

}
