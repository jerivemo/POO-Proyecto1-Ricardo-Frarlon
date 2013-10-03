package Data;


public abstract class ClassRoom {

	private String Name;
	private int classRoomNumber;
	private int capacity;
	private String location;

	public abstract int getType();

     /**
     * @param Name
     * @param classRoomNumber
     * @param capacity
     * @param location
     * 
     */         
    public ClassRoom(String Name, int classRoomNumber, int capacity, String location) {
        this.Name = Name;
        this.classRoomNumber = classRoomNumber;
        this.capacity = capacity;
        this.location = location;
    }

    
      
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getClassRoomNumber() {
        return classRoomNumber;
    }

    public void setClassRoomNumber(int classRoomNumber) {
        this.classRoomNumber = classRoomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }
        
        

}
