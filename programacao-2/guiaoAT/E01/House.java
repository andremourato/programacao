
import static java.lang.System.*;

public class House {
	
   public House(String houseType,int maxSize,int extensionSize) {
      this.houseType = houseType;
      this.extensionSize = extensionSize;
      rooms = new Room[maxSize];
      size = 0;
      doors = new Door[maxSize];
      numDoors = 0;
   }
   
	private String houseType;
	private int extensionSize;
	private Room [] rooms;
	private int size;
	private Door [] doors;
	private int numDoors;
	

   public House(String houseType) {
      this(houseType,8,4);
   }

   public int size() {
      return size;
   }

   public int maxSize() {
      return rooms.length;
   }

   public Room room(int i) {
      return rooms[i];
   }

   public int addRoom(Room r) {
      if (size == rooms.length) extendHouse();
      rooms[size] = r;
      size++;
      return size;
   }

   private void extendHouse() {
      Room [] newRooms = new Room[rooms.length+extensionSize];
      arraycopy(rooms, 0, newRooms, 0, rooms.length);
      rooms = newRooms;
   }
   
   public void addDoor(Door d) {
	  if(numDoors == doors.length) extendRooms();
      doors[numDoors] = d;
      numDoors++;
   }

	private void extendRooms(){
		Door [] newDoors = new Door[doors.length+extensionSize];
		arraycopy(doors, 0, newDoors, 0, doors.length);
		doors = newDoors;
		
	}
	
   public int numDoors() {
      return numDoors;
   }

   public int maxNumDoors() {
      return doors.length;
   }
   
	public int roomClosestToRoomType(String roomType){
		for(int i=0;i<rooms.length;i++){
			
		}
	}
   
	/*public int maxDoorsInAnyRoom(){
		for(int i=0;i<rooms.length;i++){
			
		}
	}*/
}

