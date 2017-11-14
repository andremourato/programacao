package aula9.ex3;

public class Pessoa {
	
	private final String nome;
	private final int cc;
	private final Data dataNasc;
	
	public Pessoa(String nome, int cc, Data nasc){
		this.nome = nome;
		this.cc = cc;
		dataNasc = nasc;
	}
	
	//In case 'CC' is not necessary
	public Pessoa(String nome, Data nasc){
		this(nome,-1,nasc);
	}
	
	public String nome(){ return nome; }
	public int cc(){ return cc; }
	public Data dataNasc(){ return dataNasc; }
	
	public boolean equals(Pessoa p) {
		return cc == p.cc;
	}
	
	@Override
	public String toString() {
		return toString(" ");
	}
	
	public String toString(String mid){
		return nome + mid + dataNasc;
	}
}
