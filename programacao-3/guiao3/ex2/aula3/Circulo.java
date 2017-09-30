package aula3;

public class Circulo extends Figura{
	
	private final double raio;
	
	public Circulo(Point c, double r){
		super(c);
		raio = r;
	}
	
	public Circulo(Circulo c1) {
		this(c1.centro(),c1.raio());
	}
	
	public Circulo(double r) {
		this(new Point(),r);
	}
	
	public Circulo(double x, double y, double r){
		this(new Point(x,y),r);
	}
	
	//Getter methods
	public double raio(){ return raio; }
	public double area(){ return Math.PI * raio * raio; }
	public double perimetro(){ return 2 * Math.PI * raio; }
	
	//A custom made toString() method
	@Override
	public String toString(){ return "Circulo"; }
	public boolean equals(Circulo circle){ return raio == circle.raio(); }
	public boolean intersepts(Circulo circle){ 
		//For this algorithm we are going to compare the distance between the center of both circles to the sum of the radiuses of the 2 circles
		//If the sum of both radiuses is greater or equal to the distance between the 2 center, then the circles intercept each other
		return centro.distanceTo(circle.centro) <= raio + circle.raio();
	}
}

