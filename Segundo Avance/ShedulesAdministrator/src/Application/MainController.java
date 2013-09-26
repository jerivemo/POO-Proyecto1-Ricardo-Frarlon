package Application;

import java.util.*;
import Data.*;

/**
 *
 * @author Ricardo
 */
public class MainController {

	private LinkedList<User> Users;
	private LinkedList<Semester> semestrers;
	private LinkedList<ClassRoom> classRooms;
	private LinkedList<Department> departments;
	private LinkedList<Semester> semesters;
	private LinkedList<Course> courses;

    public MainController() {
        this.Users = new LinkedList<>();
        this.semestrers = new LinkedList<>();
        this.classRooms = new LinkedList<>();
        this.departments = new LinkedList<>();
        this.courses = new LinkedList<>();
    }
    
    
    /**
     *
     * @param u User 
     * @param p Password
     * @return
     */
    public Boolean login(String u , String p)
    {
        return null;
    }

    public void insertUser(String studentCard, String name, String id, String password)
    {       
    }
    
    public void insertUser(Department department, boolean coordinator, String name, String id, String password)
    {       
    }
    
    
        
}
