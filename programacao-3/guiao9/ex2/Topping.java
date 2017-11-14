package aula9.ex2;

public class Topping extends GeladoDecorator{
	
	private final String sabor; 
	
	Topping(Gelado g, String s) {
		super(g);
		sabor = s;
		
	}
	
	public void base(int n) {
		g.base(n);
		System.out.print(" com "+sabor);
	}
	
}
