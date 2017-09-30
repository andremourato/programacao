package aula3;

public class Figura {

	protected Point centro;
	
	public Figura(Point c){
		centro = c;
	}
	
	public Point centro() { return centro; }
	@Override
	public String toString() { return "Figura";	}
	
}
