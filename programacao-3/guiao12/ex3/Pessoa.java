package aula12.ex3;

public class Pessoa {
	
	private final String nome;
	private final int cc;
	private final Data dataNasc;
	private final int contacto;
	
	public Pessoa(String nome, int cc, Data nasc, int contact){
		this.nome = nome;
		this.cc = cc;
		dataNasc = nasc;
		contacto = contact;
	}
	
	//In case 'CC' is not necessary
	public Pessoa(String nome, Data nasc, int contact){
		this(nome,-1,nasc,contact);
	}
	
	//In case 'contacto' is not necessary
	public Pessoa(String nome, int cc, Data nasc){
		this(nome,cc,nasc,-1);
	}
	
	public int contacto(){ return contacto; }
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
		return nome + mid +  contacto + mid + dataNasc;
	}
}
