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

    public Medlem getMemberByLogin(String memberUsername, String memberPassword) {
        Medlem member = null;
        String sqlQuery = "select Medlem.Id, Medlem.aNamn from Medlem\n" +
                "where Medlem.aNamn = ? and Medlem.lösen = binary ?";

        try (Connection con = DriverManager.getConnection(mysqlAddress, username, password);
             PreparedStatement stmt = con.prepareStatement(sqlQuery)) {
            stmt.setString(1, memberUsername);
            stmt.setString(2, memberPassword);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    member = new Medlem();
                    member.setId(rs.getInt("id"));
                    member.setaNamn(rs.getString("aNamn"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
}
