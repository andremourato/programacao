package aula3;

public class Rectangulo extends Figura{
	
	private final double comprimento;
	private final double largura;
	
	public Rectangulo(Point p, double w, double h){
		super(p);
		comprimento = w;
		largura = h;
	}
	
	public Rectangulo(Rectangulo r) {
		this(r.centro,r.comprimento,r.largura);
	}
	
	public Rectangulo(double w, double h) {
		this(new Point(),w,h);
	}
	
	public Rectangulo(double x, double y,double w, double h){
		this(new Point(x,y),w,h);
	}
	
	//Getter methods
	public double comprimento(){ return comprimento; }
	public double largura(){ return largura; }
	public double area() { return comprimento * largura; }
	public double perimetro() { return 2 * comprimento + 2 * largura; }
	public Point centro(){ return centro; }
	
	//A custom made toString() method
	@Override
	public String toString(){ 
		return "Retangulo";
	}
	public boolean equals(Rectangulo r){ 
		return comprimento == r.comprimento() && largura == r.largura()
			   && centro.equals(r.centro);
	}
}

