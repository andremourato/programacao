package aula6.ex2;

public class Pessoa {
	
	private final String nome;
	private final int cc;
	private final Data dataNasc;
	
	public Pessoa(String nome, int cc, Data nasc){
		this.nome = nome;
		this.cc = cc;
		dataNasc = nasc;
	
	}
	
	public String nome(){ return nome; }
	public int cc(){ return cc; }
	public Data dataNasc(){ return dataNasc; }
	
	public boolean equals(Pessoa p) {
		return cc == p.cc;
	}
	
	@Override
	public String toString(){
		return nome + ", BI: " + cc + ", Nasc. Data: "+ dataNasc;
	}
}

