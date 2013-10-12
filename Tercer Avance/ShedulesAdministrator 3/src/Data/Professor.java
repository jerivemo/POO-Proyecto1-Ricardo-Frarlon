package Data;

import java.util.LinkedList;

/**
 *
 * @author Ricardo
 */
public class Professor extends User {

	private String identificationCard;
	private Department department;
	private boolean coordinator;
	private LinkedList<Course> courses;
	private LinkedList<ScheduleBlock> possibleSchedules;

    /**
     *
     * @param identificationCard
     * @param department
     * @param coordinator
     * @param courses
     * @param possibleSchedules
     * @param name
     * @param id
     * @param password
     */
    public Professor(Department department, boolean coordinator, String name, String id, String password) {
        super(name, id, password);
        this.department = department;
        this.coordinator = coordinator;
        this.courses = new LinkedList<>();
        this.possibleSchedules = new LinkedList<>();
    }

    /**
     *
     * @return
     */
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isCoordinator() {
        return coordinator;
    }

    public void setCoordinator(boolean coordinator) {
        this.coordinator = coordinator;
    }

    public LinkedList<Course> getCourses() {
        return courses;
    }

    public void setCourses(LinkedList<Course> courses) {
        this.courses = courses;
    }

    public LinkedList<ScheduleBlock> getPossibleSchedules() {
        return possibleSchedules;
    }

    public void setPossibleSchedules(LinkedList<ScheduleBlock> possibleSchedules) {
        this.possibleSchedules = possibleSchedules;
    }
    
    /**
     *
     * @return int 
     */
    @Override
    public  int getType()
    {
        return 1;
    }
}
