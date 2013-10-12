package Application;

import java.util.*;
import Data.*;
import Presentation.CoordinatorHome;

/**
 *
 * @author Ricardo
 */
public class MainController {
    
    private LinkedList<User> Users;
//	private LinkedList<Semester> semestrers;
    private LinkedList<ClassRoom> classRooms;
    private LinkedList<Department> departments;
    private LinkedList<Semester> semesters;
    private User currentUser;    
    public ClassRoom currentClassRoom;
    

    public MainController() {
        this.Users = new LinkedList<>();
        this.semesters = new LinkedList<>();
        this.classRooms = new LinkedList<>();
        this.departments = new LinkedList<>();
        //      this.courses = new LinkedList<>();
    }

    /**
     *
     * @param u User-id
     * @param p Password
     * @return
     */
    public Boolean login(String u, String p) {
        int count = Users.size() - 1;
        while (count >= 0) {
            if ((Users.get(count).getId().equals(u)) && (Users.get(count).getPassword().equals(p))) {
                currentUser = Users.get(count);
                return true;
            }
            count--;
        }
        return false;
    }

    /**
     * Function Insert Student User
     *
     * @param studentCard
     * @param name
     * @param id
     * @param password
     */
    public void insertUser(String studentCard, String name, String id, String password) {        
        Student s = new Student(studentCard, name, id, password);
        Users.add(s);
        //  ((Student) Users.get(0)).getStudentCard();
    }

    /**
     * Function Insert Professor User
     *
     * @param department
     * @param coordinator
     * @param name
     * @param id
     * @param password
     */    
    public void insertUser(Department department, boolean coordinator, String name, String id, String password) {
        
        Professor s = new Professor(department, coordinator, name, id, password);
        Users.add(s);
    }
    
    public LinkedList<User> getUsers() {
        return Users;
    }

    public int countUsers() {
        return Users.size() - 1;
    }

    public int countClassRoom() {
        return classRooms.size() - 1;
    }

    /**
     * Function Update Info Student User
     *
     * @param studentCard
     * @param name
     * @param id
     * @param password
     * @return
     */
    public Boolean updateInfoCurrentUser(String studentCard, String name, String id, String password) {
        try {
            //currentUser.setId(id);
            currentUser.setName(name);
            currentUser.setPassword(password);
            ((Student) currentUser).setStudentCard(studentCard);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

    /**
     * Delte user by its id.
     *
     * @param id
     */
    public void deleteUser(String id) {
        
        int count = countUsers();
        while (count >= 0) {
            if (Users.get(count).getId().equals(id)) {
                Users.remove(count);
            }
            count--;
        }
    }

    /**
     * Function Update Info Professor User
     *
     * @param department
     * @param coordinator
     * @param name
     * @param id
     * @param password
     * @return
     */
    public Boolean updateInfoCurrentUser(Department department, boolean coordinator, String name, String id, String password) {
        try {
            //currentUser.setId(id);
            currentUser.setName(name);
            currentUser.setPassword(password);
            ((Professor) currentUser).setCoordinator(coordinator);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

    /**
     * Function Obtain the type of current user
     *
     * @return int
     */
    public int obtainCurrentUserType() {
        return currentUser.getType();
    }

    /**
     * Function Insert Theoretical Classroom
     *
     * @param Name
     * @param classRoomNumber
     * @param capacity
     * @param location
     * @param airConditioning
     * @param multimediaEquipment
     */
    public void insertClassRoom(String Name, int classRoomNumber, int capacity,
            String location, Boolean airConditioning,
            Boolean multimediaEquipment, int amountEquipment,
            String equipmentAvailable) {
        if (amountEquipment == 0 && equipmentAvailable.equals("")) {
            TheoreticalClassroom tc = new TheoreticalClassroom(Name, classRoomNumber, capacity, location, airConditioning, multimediaEquipment);
            classRooms.add(currentClassRoom);
        }
        
        if (currentClassRoom instanceof PracticalClassroom) {
            PracticalClassroom pc = new PracticalClassroom(Name, classRoomNumber, capacity, location, amountEquipment, equipmentAvailable);
            classRooms.add(currentClassRoom);
        }
        
    }

    public void updateClassRoom(String Name, int classRoomNumber,
            int capacity, String location, Boolean airConditioning,
            Boolean multimediaEquipment, int amountEquipment, String equipmentAvailable) {
        if (currentClassRoom instanceof TheoreticalClassroom) {
            currentClassRoom.setCapacity(capacity);
            currentClassRoom.setClassRoomNumber(classRoomNumber);
            currentClassRoom.setLocation(location);
            currentClassRoom.setName(Name);
            ((TheoreticalClassroom) currentClassRoom).setAirConditioning(airConditioning);
            ((TheoreticalClassroom) currentClassRoom).setMultimediaEquipment(multimediaEquipment);
        }

//	private Boolean airConditioning;
//	private Boolean multimediaEquipment;
        
        if (currentClassRoom instanceof PracticalClassroom) {
            currentClassRoom.setCapacity(capacity);
            currentClassRoom.setClassRoomNumber(classRoomNumber);
            currentClassRoom.setLocation(location);
            currentClassRoom.setName(Name);
            ((PracticalClassroom) currentClassRoom).setAmountEquipment(amountEquipment);
            ((PracticalClassroom) currentClassRoom).setEquipmentAvailable(equipmentAvailable);
        }
    }
    
   public LinkedList<ClassRoom> getClassRooms(){
   return classRooms;
   }
   
       public void deleteClassRoom(String name) {
        
        int count = countClassRoom();
        while (count >= 0) {
            if (classRooms.get(count).getName().equals(name)) {
                classRooms.remove(count);
            }
            count--;
        }
    }
}
