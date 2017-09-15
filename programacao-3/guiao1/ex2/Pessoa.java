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
	public String toString(){
		return String.format("%1$"+12+"s", nome)+" | "+String.format("%1$"+11+"s", cc)+" | "+String.format("%1$"+8+ "s", dataNasc);
	}
}

