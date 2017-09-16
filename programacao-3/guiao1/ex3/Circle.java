public class Circle {
	
	private final double radius;
	private final double area;
	private final double perimeter;
	private final Point center;
	
	public Circle(double x, double y, double r){
		center = new Point(x,y);
		radius = r;
		area = Math.PI * radius * radius;
		perimeter = 2 * Math.PI * radius;
	}
	
	public Circle(Point c, double r){
		center = c;
		radius = r;
		area = Math.PI * Math.pow(radius,2);
		perimeter = 2 * Math.PI * radius;
	}
	
	//Getter methods
	public double radius(){ return radius; }
	public double area(){ return area; }
	public double perimeter(){ return perimeter; }
	public Point center(){ return center; }
	
	//A custom made toString() method
	public String toString(){ 
		return "Tipo: Círculo"+
				"\nRaio: "+radius+
				"\nCentro: "+center+
				"\nÁrea: "+area+
				"\nPerimetro: "+perimeter;
	}
	public boolean equals(Circle circle){ return radius == circle.radius(); }
	public boolean intersepts(Circle circle){ 
		//For this algorithm we are going to compare the distance between the center of both circles to the sum of the radiuses of the 2 circles
		//If the sum of both radiuses is greater or equal to the distance between the 2 centers, then the circles insept each other
		return center.distanceTo(circle.center()) <= radius + circle.radius();
	}
}

