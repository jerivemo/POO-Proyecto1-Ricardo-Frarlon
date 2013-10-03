package Data;



public class TheoreticalClassroom extends ClassRoom {

	private Boolean airConditioning;
	private Boolean multimediaEquipment;

    /**
     *
     * @param Name
     * @param classRoomNumber
     * @param capacity
     * @param location
     * @param airConditioning
     * @param multimediaEquipment
     * 
     */
    public TheoreticalClassroom(String Name, int classRoomNumber, int capacity, String location,Boolean airConditioning, Boolean multimediaEquipment)
    {
        super(Name, classRoomNumber, capacity, location);
        this.airConditioning = airConditioning;
        this.multimediaEquipment = multimediaEquipment;
    }

   
    
        
    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Boolean getMultimediaEquipment() {
        return multimediaEquipment;
    }

    public void setMultimediaEquipment(Boolean multimediaEquipment) {
        this.multimediaEquipment = multimediaEquipment;
    }
    
        
        
        @Override
        public  int getType(){
        return 0;
        }
}
