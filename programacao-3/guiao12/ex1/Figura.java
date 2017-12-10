package aula12.ex1;

public abstract class Figura implements Comparable<Figura> {

	private Ponto centro;
	
	public Figura(Ponto c){
		centro = c;
	}
	
	public Ponto centro() { return centro; }
	public abstract double area();
	public abstract double perimetro();
	
	//Returns <0 if this < figura; Returns ==0 if this == figura; Returns >0 if this > figura
	public int compareTo(Figura figura){
		return (int)(this.area()-figura.area());
	}
}
