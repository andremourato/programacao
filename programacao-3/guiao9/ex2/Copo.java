package aula9.ex2;

public class Copo extends GeladoDecorator {

	private final String ingrediente;
	
	Copo(Gelado g, String i) {
		super(g);
		ingrediente = i;
	}
	
	Copo(Gelado g) {
		this(g,null);
	}
	
	public void base(int n) {
		g.base(n);
		System.out.print(" em copo"+(ingrediente==null?"":" com "+ingrediente));
	}

}
