package Repo;

import DTO.PersonalRegister;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PTapplication {

    private Connection con;
    private Properties p = new Properties();

    public PTapplication() {

        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    protected void printMedlemmar() {

        try (
                Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                Statement stmt = con1.createStatement();
                ResultSet rs = stmt.executeQuery("TODO")) {

            while (rs.next()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PTapplication();
    }
}
