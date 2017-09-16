public class Square {
	
	private final double width;
	private final double area;
	private final double perimeter;
	private final Point center;
	
	public Square(double x, double y,double w){
		center = new Point(x,y);
		width = w;
		area = width * width;
		perimeter = 4 * width;
	}
	
	public Square(Point p, double w){
		center = p;
		width = w;
		area = width * width;
		perimeter = 4 * width;
		
	}
	
	//Getter methods
	public double width(){ return width; }
	public double area(){ return area; }
	public double perimeter(){ return perimeter; }
	public Point center(){ return center; }
	
	//A custom made toString() method
	public String toString(){ 
		return "Tipo: Quadrado"+
				"\nComprimento: "+width+
				"\nCentro: "+center+
				"\nÁrea: "+area+
				"\nPerimetro: "+perimeter; 
	}
	public boolean equals(Square square){ return width == square.width(); }
	
}

