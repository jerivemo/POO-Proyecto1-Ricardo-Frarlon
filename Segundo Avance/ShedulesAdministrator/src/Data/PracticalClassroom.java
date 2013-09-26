package Data;



public class PracticalClassroom extends ClassRoom {

	private int amountEquipment;
	private String equipmentAvailable;
        
    @Override
    public  int getType()
    {
        return 1;
    }  

    
    public int getAmountEquipment() {
        return amountEquipment;
    }

    public void setAmountEquipment(int amountEquipment) {
        this.amountEquipment = amountEquipment;
    }

    public String getEquipmentAvailable() {
        return equipmentAvailable;
    }

    public void setEquipmentAvailable(String equipmentAvailable) {
        this.equipmentAvailable = equipmentAvailable;
    }

    
    /**
     * @param Name
     * @param classRoomNumber
     * @param capacity
     * @param location
     * @param amountEquipment
     * @param equipmentAvailable
     */
    public PracticalClassroom(String Name, int classRoomNumber, int capacity, String location, int amountEquipment, String equipmentAvailable) {
        super(Name,classRoomNumber,capacity,location);
        this.amountEquipment = amountEquipment;
        this.equipmentAvailable = equipmentAvailable;
    }

}
