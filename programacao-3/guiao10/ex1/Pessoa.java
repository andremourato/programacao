package aula10.ex1;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cc != other.cc)
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return toString(" ");
	}
	
	public String toString(String mid){
		return nome + mid + dataNasc;
	}
}
