public class Rectangle {
	
	private final double width;
	private final double height;
	private final double area;
	private final double perimeter;
	private final Point center;
	
	public Rectangle(double x, double y,double w, double h){
		center = new Point(x,y);
		width = w;
		height = h;
		area = width * height;
		perimeter = 2 * width + 2 * height;
	}
	public Rectangle(Point p, double w, double h){
		center = p;
		width = w;
		height = h;
		area = width * height;
		perimeter = 2 * width + 2 * height;
	}
	
	//Getter methods
	public double width(){ return width; }
	public double height(){ return height; }
	public Point center(){ return center; }
	
	//A custom made toString() method
	public String toString(){ 
		return "Tipo: Retângulo"+
				"\nComprimento: "+width+
				"\nLargura: "+height+
				"\nCentro: "+center+
				"\nÁrea: "+area+
				"\nPerimetro: "+perimeter;
	}
	public boolean equals(Rectangle rectangle){ return width == rectangle.width() && height == rectangle.height(); }
	
	
}

