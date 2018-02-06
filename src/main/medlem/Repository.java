import DTO.Medlem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Repository {
    private String username;
    private String password;
    private String mysqlAddress;
    
    public Repository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Properties p = new Properties();
        try (FileInputStream file = new FileInputStream("settings.properties")) {
            p.load(file);
            username = p.getProperty("username");
            password = p.getProperty("password");
            mysqlAddress = p.getProperty("mysqlAddress");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Medlem getMemberByLogin(String username, String password) {
        Medlem member;
        String sqlQuery = "select count(medlem.id) from medlem\n" +
                "where medlem.aNamn = ? and medlem.lösen = binary ?";

        try (Connection con = DriverManager.getConnection(mysqlAddress, username, password);
             PreparedStatement stmt = con.prepareStatement(sqlQuery)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    member = new Medlem();
                    //member.
                } else {
                    member = null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not connect to database.");
        }
        // TODO
        return null;
    }
}
