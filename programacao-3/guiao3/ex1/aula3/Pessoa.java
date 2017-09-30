package aula3;

public class Pessoa {
	
	protected final String nome;
	protected final int cc;
	protected final Data dataNasc;
	
	public Pessoa(String nome, int cc, Data nasc){
		this.nome = nome;
		this.cc = cc;
		dataNasc = nasc;
	
	}
	
	public String nome(){ return nome; }
	public int cc(){ return cc; }
	public Data dataNasc(){ return dataNasc; }
	
	@Override
	public String toString(){
		return nome + ", BI: " + cc + ", Nasc. Data: "+ dataNasc;
	}
}

