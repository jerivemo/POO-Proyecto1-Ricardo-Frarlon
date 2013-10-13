/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shedulesadministrator;

import Application.MainController;
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
       // final MainController ins = new MainController();
        ins.insertUser("201042705", "Frarlon", "2", "2");
          ins.insertUser("201042705", "Frarlon", "2", "2");
            ins.insertUser("201042705", "Frarlon", "4", "4");

}
    
   // public void verificar(){}
}
