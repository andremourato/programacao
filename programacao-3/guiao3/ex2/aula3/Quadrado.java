package aula3;

public class Quadrado extends Figura{
	
	private final double comprimento;
	
	public Quadrado(Point p, double w){
		super(p);
		comprimento = w;		
	}
	
	public Quadrado(Quadrado q) {
		this(q.centro, q.comprimento);
	}
	
	public Quadrado(double comprimento) {
		this(new Point(),comprimento);
	}
	
	public Quadrado(double x, double y,double w){
		this(new Point(x,y),w);
	}
	
	//Getter methods
	public double comprimento(){ return comprimento; }
	public double area(){ return comprimento * comprimento; }
	public double perimetro(){ return 4 * comprimento; }
	public Point centro(){ return centro; }
	
	//A custom made toString() method
	@Override
	public String toString(){ return "Quadrado"; }
	public boolean equals(Quadrado q){ 
		return comprimento == q.comprimento() && centro.equals(q.centro);
	}
}

