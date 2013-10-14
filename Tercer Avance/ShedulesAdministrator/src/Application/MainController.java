package Application;

import java.util.*;
import Data.*;
import Presentation.CoordinatorHome;
import Presentation.StudentHome;
import Presentation.TeacherHome;
import shedulesadministrator.ShedulesAdministrator;
import static shedulesadministrator.ShedulesAdministrator.ins;

/**
 *
 * @author Ricardo
 */
public class MainController {

    public LinkedList<User> Users;
    public LinkedList<ClassRoom> classRooms;
    public LinkedList<Department> departments;
    public LinkedList<Semester> semesters;
    public LinkedList<Course> courses;
    public User currentUser;
    public User currentUserStudent;
    public User currentUserTeacher;
    public ClassRoom currentClassRoom;
    public Course currentCourse;
    LinkedList<ScheduleGeneral> shedule;
    LinkedList<ScheduleGeneral> unAsignedshedule;
    public CoordinatorHome home = new CoordinatorHome();
    public TeacherHome teacherHome = new TeacherHome();
    public StudentHome studentHome = new StudentHome();
    public MainController() {
        this.Users = new LinkedList<>();
        this.semesters = new LinkedList<>();
        this.classRooms = new LinkedList<>();
        this.departments = new LinkedList<>();
        this.courses = new LinkedList<>();
        //      this.courses = new LinkedList<>();
        this.shedule = new LinkedList<>();
        this.unAsignedshedule = new LinkedList<>();
        this.currentUserStudent = new Student("", "", "", "");
        this.currentUserTeacher = new Professor(new Department(""), false, "", "", "");
        this.currentCourse = new TheoreticalCourse("", "", "", 0, 0);
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
                
                if(currentUser instanceof Professor){
                if(((Professor)currentUser).isCoordinator()){
               ins.home.setVisible(true);
                //home.setVisible(true);
                 ins.fillData(ins.home);
                
                }
                else{
                teacherHome.setVisible(true);
                }
                }
                else {
                studentHome.setVisible(true);
                
                }
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
    public void deleteUser(String id, int kind) {

        int count = countUsers() - 1;
        while (count >= 0) {
            if (Users.get(count).getId().equals(id)) {
                Users.remove(count);
            }
            count--;
        }
        if (kind == 1) {
            comboUserActionStudent(home);
            home.jComboBoxStudent.removeAllItems();
            int countU = Users.size() - 1;
            while (countU >= 0) {
                if (Users.get(countU) instanceof Student) {
                    home.jComboBoxStudent.addItem(Users.get(countU).getId());
                }
                countU--;
            }
        }
        if (kind == 2) {
            comboUserActionTeacher(home);
          //  home.jComboBoxTeacher.removeAllItems();
            int countT = Users.size() - 1;
            while (countT >= 0) {
                if (Users.get(countT) instanceof Professor) {
                    home.jComboBoxTeacher.addItem(Users.get(countT).getId());
                }
                countT--;
            }
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
            classRooms.add(tc);

        } else {
            PracticalClassroom pc = new PracticalClassroom(Name, classRoomNumber, capacity, location, amountEquipment, equipmentAvailable);
            classRooms.add(pc);
        }

    }

    /**
     *
     * @param Name
     * @param classRoomNumber
     * @param capacity
     * @param location
     * @param airConditioning
     * @param multimediaEquipment
     * @param amountEquipment
     * @param equipmentAvailable
     */
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
        fillClassroom(home);
    }

    /**
     *
     * @param home
     */
    public void updateCourse(CoordinatorHome home) {
        if (currentCourse != null) {
            currentCourse.setCourseID(home.jTextFieldCourseID.getText());
            currentCourse.setName(home.jTextFieldCourseName.getText());
            currentCourse.setCredits(Integer.parseInt(home.jTextFieldCourseCredit.getText()));
            if (currentCourse instanceof TheoreticalCourse) {
                ((TheoreticalCourse) currentCourse).setWebNotes(home.jTextFieldCourseWebNotes.getText());
            }
            if (currentCourse instanceof PracticalCourse) {
                ((PracticalCourse) currentCourse).setOperatingSystem(home.jTextFieldCourseOP.getText());
                ((PracticalCourse) currentCourse).setSupportMaterial(home.jTextFieldCourseSupprotMaterial.getText());
            }
        }
    }

    /**
     *
     */
    public void deleteCourse() {
        int contS = semesters.size() - 1;
        int contC = 0;

        while (contS >= 0) {
            //    
            LinkedList<Course> tempc = semesters.get(contS).getListCourse();
            //   home.jComboBoxSemester.addItem(semesters.get(contS).getId());
            contC = tempc.size() - 1;
            String finC = home.jComboBoxCourseID.getSelectedItem().toString();
          
            while (contC >= 0) {
                if (finC.equalsIgnoreCase(tempc.get(contC).getCourseID())) {

                    tempc.remove(contC);

                }
                contC--;
            }
            contS--;
        }
        //  home.jComboBoxCourseID.removeAllItems();
    }

    /**
     *
     */
    public void updateDepartments() {
        int cont = departments.size();
        String dep = home.jComboBoxDepartmentName.getSelectedItem().toString();
        while (cont >= 0) {
            if (departments.get(cont).getName().equalsIgnoreCase(dep)) {

                departments.get(cont).setName(home.jTextFieldDepartmentName.getText());
            }
        }

    }

    /**
     *
     * @return
     */
    public LinkedList<ClassRoom> getClassRooms() {
        return classRooms;
    }

    /**
     *
     * @param name
     */
    public void deleteClassRoom(String name) {

        int count = countClassRoom();
        while (count >= 0) {
            if (classRooms.get(count).getName().equals(name)) {
                classRooms.remove(count);
            }
            count--;
        }
        fillClassroom(home);
    }

    /**
     *
     */
    public void generateSchedule() {
        shedule = new LinkedList<>();
        unAsignedshedule = new LinkedList<>();

        for (int ind = 0; ind < Users.size(); ind++) {
            if (Users.get(ind).getType() == 1 && ((Professor) Users.get(ind)).cantCourses() != 0) {
                Professor tempProf = (Professor) Users.get(ind);
                for (int ind2 = 0; ind2 < tempProf.getCourses().size(); ind2++) {
                    boolean flag = true;
                    int ind3 = 0;
                    while (flag != true) {
                        boolean b = generateScheduleAux(tempProf, tempProf.getCourses().get(ind2),
                                tempProf.getPossibleSchedules().get(ind3));
                        if (b == true) {
                            flag = false;
                        } else {
                            ind3 = ind + 1;
                            if (ind3 == tempProf.getPossibleSchedules().size()) {

                                flag = false;
                                ScheduleGeneral nn = new ScheduleGeneral(tempProf.getCourses().get(ind2), tempProf);
                                unAsignedshedule.add(nn);
                            }
                        }//End While
                    }//End for
                }//end for    
            }//end if
        }//end for    
    }

    /**
     * Insert The Course in the list of Shedules
     *
     * @param p
     * @param c
     * @param sb
     * @return
     */
    public boolean generateScheduleAux(Professor p, Course c, ScheduleBlock sb) {

        for (int ind = 0; ind < classRooms.size(); ind++) {
            if (shedule.size() == 0) {
                ScheduleGeneral nn = new ScheduleGeneral(c, classRooms.get(ind), p, sb);
                shedule.add(nn);
                return true;
            } else {
                for (int ind2 = 0; ind2 < shedule.size(); ind2++) {
                    ScheduleGeneral tmp = shedule.get(ind2);

                    if (tmp.getRoom().getClassRoomNumber() != classRooms.get(ind).getClassRoomNumber()
                            && tmp.getShedule().getDay().compareTo(sb.getDay()) != 0
                            && tmp.getShedule().getStartTime().compareTo(sb.getStartTime()) != 0
                            && tmp.getShedule().getEndTime().compareTo(sb.getEndTime()) != 0) {
                        ScheduleGeneral nn2 = new ScheduleGeneral(c, classRooms.get(ind), p, sb);
                        shedule.add(nn2);
                        return true;
                    }// end If                   
                }// End for    
            } //End Else
        }//End For
        return false;
    }

    /**
     *
     * @return
     */
    public boolean isSheduleGenerated() {
        if (shedule.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param home
     */
    public void fillData(CoordinatorHome home) {

        fillUser(home);
        fillClassroom(home);
        fillCourses(home);
        fillDepartment(home);
        fillMyinfo(home);
    }

    /**
     *
     * @param home
     */
    public void fillUser(CoordinatorHome home) {
        int count = ShedulesAdministrator.ins.countUsers();
        LinkedList<User> tempUser = ShedulesAdministrator.ins.getUsers();
        boolean firstTimeP = true;
        boolean firstTimeS = true;
        // ShedulesAdministrator.ins.user

        //add the user the the Combobox User
        while (count >= 0) {
            if (tempUser.get(count) instanceof Professor && firstTimeP) {
                home.jComboBoxTeacher.addItem(tempUser.get(count).getId());
                home.jTextFieldTeacherID.setText(tempUser.get(count).getId());
                home.jTextFieldTeacherName.setText(tempUser.get(count).getName());
                home.jTextFieldTeacherDepartment.setText(((Professor) tempUser.get(count)).getDepartment().getName());
                home.jTextFieldTeacherPassword.setText(tempUser.get(count).getPassword());
                home.jCheckBoxCoordinator.setSelected(((Professor) tempUser.get(count)).isCoordinator());
                firstTimeP = false;
                count--;
            }
            if (tempUser.get(count) instanceof Professor && !firstTimeP) {

                home.jComboBoxTeacher.addItem(tempUser.get(count).getId());
                count--;
            } else if (firstTimeS) {
                home.jComboBoxStudent.addItem(tempUser.get(count).getId());
                home.jTextFieldStudentName.setText(tempUser.get(count).getName());
                home.jTextFieldStudentID.setText(tempUser.get(count).getId());
                home.jTextFieldStudentCard.setText(((Student) tempUser.get(count)).getStudentCard());
                home.jTextFieldStudentPassword.setText(tempUser.get(count).getPassword());
                firstTimeS = false;
                count--;
            } else {
                home.jComboBoxStudent.addItem(tempUser.get(count).getId());
                count--;
            }

        }
    }

    /**
     *
     * @param home
     */
    public void comboUserActionStudent(CoordinatorHome home) {

        if (home.jComboBoxStudent.getSelectedIndex() != -1) {
            String userF = home.jComboBoxStudent.getSelectedItem().toString();


            int count = Users.size() - 1;
            while (count >= 0) {
                if (Users.get(count).getId().equals(userF)) {
                    // home.jComboBoxStudent.addItem(Users.get(count).getId());
                    currentUserStudent = (Student) Users.get(count);
                    //    home.jComboBoxStudent.addItem(Users.get(count).getId());
                    home.jTextFieldStudentName.setText(Users.get(count).getName());
                    home.jTextFieldStudentID.setText(Users.get(count).getId());
                    home.jTextFieldStudentCard.setText(((Student) Users.get(count)).getStudentCard());
                    home.jTextFieldStudentPassword.setText(Users.get(count).getPassword());

                }

                count--;
            }
        }
    }

    /**
     *
     */
    public void updateCurrentTeacher() {

        //currentUserTeacher = (Professor) Users.get(count);
        currentUserTeacher.setId(home.jTextFieldTeacherID.getText());
        currentUserTeacher.setName(home.jTextFieldTeacherName.getText());
        currentUserTeacher.setPassword(home.jTextFieldTeacherPassword.getText());
        ((Professor) currentUserTeacher).setDepartment(new Department(home.jTextFieldTeacherDepartment.getText()));
        ((Professor) currentUserTeacher).setCoordinator(home.jCheckBoxCoordinator.isSelected());
        home.jComboBoxTeacher.removeAllItems();
         int count = Users.size() - 1;
         while(count>=0){
         if(Users.get(count) instanceof Professor){
         home.jComboBoxTeacher.addItem(Users.get(count).getId());
         }
         count--;
         }
        comboUserActionTeacher(home);
       // 
      
    }
    
    /**
     * 
     */
    
        public void updateCurrentStudent() {

        //currentUserTeacher = (Professor) Users.get(count);
        currentUserStudent.setId(home.jTextFieldStudentID.getText());
        currentUserStudent.setName(home.jTextFieldStudentName.getText());
        currentUserStudent.setPassword(home.jTextFieldStudentPassword.getText());
      //  ((Student) currentUserStudent).setDepartment(new Department(home.jTextFieldTeacherDepartment.getText()));
        ((Student) currentUserStudent).setStudentCard(home.jTextFieldStudentID.getText());
        home.jComboBoxStudent.removeAllItems();
         int count = Users.size() - 1;
         while(count>=0){
         if(Users.get(count) instanceof Student){
         home.jComboBoxStudent.addItem(Users.get(count).getId());
         }
         count--;
         }
        comboUserActionStudent(home);
       // 
      
    }
    

    /**
     *
     * @param home
     */
    public void comboUserActionTeacher(CoordinatorHome home) {
        if (home.jComboBoxTeacher.getSelectedIndex() != -1) {
            String userF = home.jComboBoxTeacher.getSelectedItem().toString();

            int count = Users.size() - 1;
            while (count >= 0) {
                if (Users.get(count).getId().equals(userF)) {
                    currentUserTeacher = (Professor) Users.get(count);
                    home.jTextFieldTeacherID.setText(Users.get(count).getId());
                    home.jTextFieldTeacherName.setText(Users.get(count).getName());
                    home.jTextFieldTeacherDepartment.setText(((Professor) Users.get(count)).getDepartment().getName());
                    home.jTextFieldTeacherPassword.setText(Users.get(count).getPassword());
                    home.jCheckBoxCoordinator.setSelected(((Professor) Users.get(count)).isCoordinator());

                }
                count--;
            }
        }
    }

    /**
     *
     * @param home
     */
    public void comboUserActionCourse(CoordinatorHome home) {

        int contS = semesters.size() - 1;
        int contC = 0;

        while (contS >= 0) {
            //    
            LinkedList<Course> tempc = semesters.get(contS).getListCourse();
            //   home.jComboBoxSemester.addItem(semesters.get(contS).getId());
            contC = tempc.size() - 1;
            if(home.jComboBoxCourseID.getSelectedIndex()!=-1){
            String finC = home.jComboBoxCourseID.getSelectedItem().toString();
            home.jComboBoxCourseID.removeAllItems();
            while (contC >= 0) {
                if (finC.equalsIgnoreCase(tempc.get(contC).getCourseID())) {
                    ins.currentCourse = tempc.get(contC);
                    home.jComboBoxCourseID.addItem(tempc.get(contC).getCourseID());
                    home.jTextFieldCourseName.setText(tempc.get(contC).getName());
                    home.jTextFieldCourseID.setText(tempc.get(contC).getCourseID());
                    home.jTextFieldCourseCredit.setText(String.valueOf(tempc.get(contC).getCredits()));

                    if (tempc.get(contC) instanceof TheoreticalCourse) {
                        home.jTextFieldCourseWebNotes.setText(((TheoreticalCourse) tempc.get(contC)).getWebNotes());
                    } else {
                        //  home.jTextFieldCourseWebNotes.setEnabled(firstT);
                        home.jTextFieldCourseSupprotMaterial.setText(((PracticalCourse) tempc.get(contC)).getSupportMaterial());
                        home.jTextFieldCourseOP.setText(((PracticalCourse) tempc.get(contC)).getOperatingSystem());
                    }
                } else {
                    home.jComboBoxCourseID.addItem(tempc.get(contC).getCourseID());
                }
                contC--;
            }
            contS--;
        }
        }

    }

    /**
     *
     * @param home
     */
    public void fillClassroom(CoordinatorHome home) {
        home.jComboBoxClassRoomName.removeAllItems();
        int countClassRoom = ins.countClassRoom();
        LinkedList<ClassRoom> tempClassRooms = ins.getClassRooms();
        boolean firsTimeClass = true;

        while (countClassRoom >= 0) {
            if (firsTimeClass) {
                ins.currentClassRoom = tempClassRooms.get(countClassRoom);
                home.jComboBoxClassRoomName.addItem(tempClassRooms.get(countClassRoom).getName());
                home.jTextFieldClassRoomName.setText(tempClassRooms.get(countClassRoom).getName());
                home.jTextFieldClassRoomNumber.setText(String.valueOf(tempClassRooms.get(countClassRoom).getClassRoomNumber()));
                home.jTextFieldClassRoomCapacity.setText(String.valueOf(tempClassRooms.get(countClassRoom).getCapacity()));
                home.jTextFieldClassRoomLocation.setText(tempClassRooms.get(countClassRoom).getLocation());
                firsTimeClass = false;
                if (tempClassRooms.get(countClassRoom) instanceof TheoreticalClassroom) {
                    home.jCheckBoxAirConditioning.setSelected(((TheoreticalClassroom) tempClassRooms.get(countClassRoom)).getAirConditioning());
                    home.jCheckBoxMultimediaItems.setSelected(((TheoreticalClassroom) tempClassRooms.get(countClassRoom)).getMultimediaEquipment());

                }
                if (tempClassRooms.get(countClassRoom) instanceof PracticalClassroom) {
                    home.jTextFieldEquipmentAvailable.setText(((PracticalClassroom) tempClassRooms.get(countClassRoom)).getEquipmentAvailable());
                    home.jTextFieldAmountEquipment.setText(String.valueOf(((PracticalClassroom) tempClassRooms.get(countClassRoom)).getAmountEquipment()));

                }

            } else {
                home.jComboBoxClassRoomName.addItem(tempClassRooms.get(countClassRoom).getName());

            }
            countClassRoom--;
        }
    }

    /**
     *
     * @param home
     */
    public void fillDepartment(CoordinatorHome home) {
        home.jComboBoxDepartmentName.removeAllItems();
        int cont = departments.size() - 1;
        boolean firsTime = true;
        while (cont >= 0) {
            if (firsTime) {
                home.jComboBoxDepartmentName.addItem(departments.get(cont).getName());
                home.jTextFieldDepartmentName.setText(departments.get(cont).getName());
            } else {
                home.jComboBoxDepartmentName.addItem(departments.get(cont).getName());
            }
            cont--;
        }


    }

    /**
     *
     * @param home
     */
    public void fillCourses(CoordinatorHome home) {
        int contS = semesters.size() - 1;
        int contC = 0;
        boolean firstT = true;
        while (contS >= 0) {

            LinkedList<Course> tempc = semesters.get(contS).getListCourse();
            home.jComboBoxSemester.addItem(semesters.get(contS).getId());
            contC = tempc.size() - 1;
            while (contC >= 0) {
                if (firstT) {
                    ins.currentCourse = tempc.get(contC);
                    home.jComboBoxCourseID.addItem(tempc.get(contC).getCourseID());
                    home.jTextFieldCourseName.setText(tempc.get(contC).getName());
                    home.jTextFieldCourseID.setText(tempc.get(contC).getCourseID());
                    home.jTextFieldCourseCredit.setText(String.valueOf(tempc.get(contC).getCredits()));
                    firstT = false;
                    if (tempc.get(contC) instanceof TheoreticalCourse) {
                        home.jTextFieldCourseWebNotes.setText(((TheoreticalCourse) tempc.get(contC)).getWebNotes());
                    } else {
                        //  home.jTextFieldCourseWebNotes.setEnabled(firstT);
                        home.jTextFieldCourseSupprotMaterial.setText(((PracticalCourse) tempc.get(contC)).getSupportMaterial());
                        home.jTextFieldCourseOP.setText(((PracticalCourse) tempc.get(contC)).getOperatingSystem());
                    }

                } else {
                    home.jComboBoxCourseID.addItem(tempc.get(contC).getCourseID());

                }

                contC--;
            }

            contS--;
        }


    }

    /**
     *
     * @param home
     */
    public void fillMyinfo(CoordinatorHome home) {
        home.jTextFieldMyInfoID.setText(currentUser.getId());
        home.jTextFieldMyInfoName.setText(currentUser.getName());
        home.jTextFieldMyInfoPasword.setText(currentUser.getPassword());
        home.jTextFieldMyInfoDepartment.setText("Computacion");
    }

    /**
     *
     */
    public void updateCurrentUser() {

        currentUser.setId(home.jTextFieldMyInfoID.getText());
        currentUser.setName(home.jTextFieldMyInfoName.getText());
        currentUser.setPassword(home.jTextFieldMyInfoPasword.getText());
    }
}
