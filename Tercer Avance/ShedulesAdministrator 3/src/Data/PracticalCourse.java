package Data;

public class PracticalCourse extends Course {

	private String supportMaterial;
	private String operatingSystem;

    public PracticalCourse(String supportMaterial, String operatingSystem, String name, String courseID, int credits, int weekHours) {
        super(name, courseID, credits, weekHours);
        this.supportMaterial = supportMaterial;
        this.operatingSystem = operatingSystem;
    }

    
           
    @Override
    public  int getType()
    {
        return 1;
    } 

    public String getSupportMaterial() {
        return supportMaterial;
    }

    public void setSupportMaterial(String supportMaterial) {
        this.supportMaterial = supportMaterial;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    
        
}
