package aula9.ex2;

public abstract class GeladoDecorator implements Gelado {
	
	protected Gelado g;
	GeladoDecorator(Gelado g){ this.g = g; }
}
