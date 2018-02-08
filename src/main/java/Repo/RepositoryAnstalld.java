package Repo;

import DTO.IncheckedPeople;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepositoryAnstalld {

    Properties p = new Properties();
    RepositoryAdmin ra = new RepositoryAdmin();

    public RepositoryAnstalld() {
        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    protected List<IncheckedPeople> getAllInchecks(){

        List<IncheckedPeople> temp = new ArrayList<>();

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                Statement stnmt = con.createStatement();
                ResultSet rs = stnmt.executeQuery("select * from IncheckedPeople")
        ){

            while(rs.next()){



            }


        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

}
