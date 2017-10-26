package aula6.ex1;

public class Legume extends Alimento implements AlimentoVegetariano{
	
	private final String nome;
	
	public Legume(String nome, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legume other = (Legume) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Legume, "+super.toString();
	}
	
}
