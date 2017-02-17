

public class Door {

   public Door(int r1, int r2, double w, double h) {
		this.w = w;
		this.h = h;
		this.r1 = r1;
		this.r2 = r2;
   }
   
   private double w; //width of the door
   private double h; // height of the door
   private int r1;
   private int r2;
   
	public double area(){ //area of the door
		return w * h;
	}
}
