public class Room {
	
	private String roomType;
	private Point bl;
	private Point tr;
	
	public Room(String roomType, Point bl, Point tr){
		
		this.roomType = roomType;
		this.bl = bl;
		this.tr = tr;
	}
	
	public String roomType(){
		return roomType;
	}
	
	public Point bottomLeft(){
		return bl;
	}
	
	public Point topRight(){
		return tr;
	}
	
	public Point geomCenter(){
		return new Point((tr.x()+bl.x())/2,(tr.y()+bl.y())/2);
	}
	
	public double area(){
		return (tr.y()-bl.y())*(tr.x()-bl.x());
	}
	
}

