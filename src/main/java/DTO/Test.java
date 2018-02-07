package DTO;

import View.ViewAdmin;
import java.sql.SQLException;

public class Test {     
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ViewAdmin v = new ViewAdmin();
        v.AddPassView();
    }
}