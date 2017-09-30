package aula3;

public class Point {
	
	private final double x;
	private final double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	//Getter methods
	public double x(){ return x; }
	public double y(){ return y; }
	public String toString(){ return "("+x+","+y+")"; }
	
	//Determines the distance between 2 points
	public double distanceTo(Point point){
		return Math.sqrt(Math.pow(point.x()-x,2)+Math.pow(point.y()-y,2));
	}
	
	public boolean equals(Point p) { return x == p.x && y ==p.y; }
	
}
