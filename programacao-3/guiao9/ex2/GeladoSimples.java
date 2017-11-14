package aula9.ex2;

public class GeladoSimples implements Gelado {
	
	private final String sabor;
	
	public GeladoSimples(String s) {
		sabor = s;
	}
	
	@Override
	public void base(int n) {
		System.out.print("\n"+n+" bolas de gelado de "+sabor);
	}

}
