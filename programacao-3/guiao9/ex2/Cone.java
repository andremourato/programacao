package aula9.ex2;

public class Cone extends GeladoDecorator{
	
	Cone(Gelado g) {
		super(g);
	}
	
	public void base(int n) {
		g.base(n);
		System.out.print(" em cone");
	}
	
}
