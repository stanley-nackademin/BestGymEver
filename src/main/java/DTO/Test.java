package DTO;

import Controller.ControllerAdmin;
import View.ViewAdmin;
import java.sql.SQLException;

public class Test {     
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ViewAdmin va = new ViewAdmin();
        ControllerAdmin c = new ControllerAdmin();
        va.displayAdminMenu();
        //System.out.println(c.getTraningsId("Yoga"));
    }
}