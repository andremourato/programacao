package aula11.ex3;

public class PratoVegetariano extends Prato {

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	@Override
	public boolean addIngrediente(Alimento alimento) {
		if(alimento == null) return false;
		if(alimento instanceof AlimentoVegetariano) {
			return super.addIngrediente(alimento);
		}
		return false;
	}
	
}