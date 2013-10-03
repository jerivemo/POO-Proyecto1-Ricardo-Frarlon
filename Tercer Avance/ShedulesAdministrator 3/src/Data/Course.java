package Data;



public abstract class Course {

	private String name;
	private String courseID;
	private int credits;
	private int weekHours;

	public abstract int getType();

    public Course(String name, String courseID, int credits, int weekHours) {
        this.name = name;
        this.courseID = courseID;
        this.credits = credits;
        this.weekHours = weekHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getWeekHours() {
        return weekHours;
    }

    public void setWeekHours(int weekHours) {
        this.weekHours = weekHours;
    }
        

        

}
