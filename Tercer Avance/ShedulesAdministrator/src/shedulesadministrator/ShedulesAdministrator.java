/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shedulesadministrator;

import Application.MainController;
import Data.Course;
import Data.Department;
import Data.Semester;
import Data.TheoreticalCourse;
import Data.User;
import Presentation.CoordinatorHome;
import Presentation.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * @author Ricardo
 */
public class ShedulesAdministrator {
     public static  MainController ins = new MainController();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Login log = new Login();
        log.setVisible(true);
        int COST_CREDITS=3;
       // final MainController ins = new MainController();
        ins.insertUser("201042705", "Frarlon", "2", "2");
        ins.insertUser("201042705", "Frarlon", "4", "4");
        ins.departments.add(new Department("Computacion"));
        ins.insertUser(ins.departments.get(0), true, "Leonardo Viquez", "1", "1");
        ins.insertUser(ins.departments.get(0), true, "Leonardo Viquez", "3", "3");
        
        ins.insertClassRoom("A", 1, 20, "Computacion", Boolean.TRUE, Boolean.TRUE, 0, "");
        ins.semesters.add(new Semester(1));
        ins.semesters.get(0).insertCourse(new TheoreticalCourse("WWw.tec-digital.itcr.ac.cr","POO","1",3,3*COST_CREDITS));
        ins.semesters.get(0).insertCourse(new TheoreticalCourse("WWw.tec-digital.itcr.ac.cr","BD2","2",3,3*COST_CREDITS));
     
}
    
   // public void verificar(){}
}
