
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
      size++; //increments the number of rooms. Use this value when working with the number of rooms
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
      numDoors++; //increments the number of doors. Use this value when working with the number of doors
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

	public int roomClosestToRoomType(String roomType){ //searches for the closest room
		double minDist = 999;
		double dist = 0;
		int closestIndex = 0;
		for(int i=0;i<size;i++){
			if(rooms[i].roomType().equals(roomType)){ //we fix the room of type roomType and search for the closest room
				for(int j=0;j<size;j++){
					if(!roomType.equals(rooms[j].roomType())){
						dist = rooms[i].geomCenter().distTo(rooms[j].geomCenter()); //checks the distance between two rooms
						if(dist<minDist){ //checks the distance to every other room
							closestIndex = j;
							minDist = dist;
						}
					}
				}
			}
		}
		return closestIndex;
	}

	public int maxDoorsInAnyRoom(){
		int[] numberDoors = new int[size];
		for(int i=0;i<numDoors;i++){
			for (int j = 0; j < size; j++){
				if(doors[i].room1()==j) numberDoors[j]++;
				if(doors[i].room2()==j) numberDoors[j]++;
			}
		}
		int maxDoors = 0;
		for(int i:numberDoors) if(i>maxDoors) maxDoors = i; //find the highest number of doors in the array
		return maxDoors;
	}
}

