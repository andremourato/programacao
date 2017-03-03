import static java.lang.System.*;

public class House {
	
	private String houseType;
	private int extensionSize;
	private int size = 0;
	private Room[] rooms;
	private int numTypes = 0;
	private RoomTypeCount[] typeCount = new RoomTypeCount[1];
	
	public House(String houseType){
		this(houseType, 8, 4); //inicializa-se o array com 8 posições inicialmente e com expansoes de 4	
	}
	
	public House(String houseType, int size, int extensionSize){
		
		this.houseType = houseType;
		this.extensionSize = extensionSize;
		rooms = new Room[size]; //inicializa-se o array com 8 posições inicialmente
	}
	
	public void addRoom(Room room){
		
		//adiciona divisao ao array rooms
		if(size == rooms.length) extendHouse(); //aumenta o tamanho do array caso todas as divisões estejam ocupadas
		rooms[size] = room;
		size++;
		//adiciona tipo de divisao ao array typeCount
		if (hasType(room.roomType())) incrementType(room.roomType()); //se existir divisao do tipo roomType, incrementa a quantidade
		else addRoomType(room.roomType()); //se não existir nenhuma divisão desse tipo, então cria um tipo novo
	}
	
	public int size(){
		return size;
	}
	
	public int maxSize(){
		return rooms.length;
	}
	
	public Room room(int index){
		return rooms[index];
	}
	
	public double area(){
		
		int totalArea = 0;
		for(int i=0; i<size; i++){
			totalArea += rooms[i].area();
		}
		return totalArea;
	}
	
	public RoomTypeCount[] getRoomTypeCounts(){ //devolve o array typeCount com a informação sobre a quantidade de divisoes
		return typeCount;
	}
	
	public void printInfo(){
		for(int i=0; i<numTypes; i++){
			out.printf("Existem %d %s na casa\n",typeCount[i].count,typeCount[i].roomType);
		}
		out.printf("A distancia media entre divisoes e: %.3f\n",averageRoomDistance());
		out.println();
	}
	
	public double averageRoomDistance(){
		
		int numDistances = 0;
		double totalDistance = 0;
		for(int i=0; i<size ;i++){
			for(int j=0; j<size ; j++){
				totalDistance += rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				numDistances++;
			}
		}
		return totalDistance/numDistances;
	}
	
	private void incrementType(String roomType){
		
		for(int i=0; i<numTypes; i++){ //procura e incrementa a quantidade de divisoes do tipo roomType
			if(typeCount[i].roomType.equals(roomType)) typeCount[i].count++;
		}
	}
	
	private boolean hasType(String roomType){ //percorre o array procurando se existe alguma divisao do tipo roomType
		if(numTypes == 0) return false;
		for(int i=0; i<numTypes; i++){
			if(typeCount[i].roomType.equals(roomType)) return true;
		}
		return false;
	}
	
	private void extendHouse(){
		
		Room[] tempRooms = new Room[size+extensionSize];
		arraycopy(rooms, 0, tempRooms, 0, size);
		rooms = tempRooms;
	}
	
	private void addRoomType(String roomType){
		
		//expande o array
		RoomTypeCount[] temp = new RoomTypeCount[typeCount.length+1];
		arraycopy(typeCount, 0, temp, 0, numTypes+1);
		typeCount = temp;
		//atribui o valor ao elemento criado
		typeCount[numTypes] = new RoomTypeCount();
		typeCount[numTypes].roomType = roomType;
		typeCount[numTypes].count = 1;
		numTypes++;
	}
}

