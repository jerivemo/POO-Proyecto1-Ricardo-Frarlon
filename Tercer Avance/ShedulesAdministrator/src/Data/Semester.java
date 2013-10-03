package Data;

import java.util.*;

public class Semester {

	private LinkedList<Course> courses;
	private int id;

    public Semester(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	
        public Course obtainCourse(String n) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
        
        public Boolean insertCourse(String n) {
		
	return false;
        }

}
