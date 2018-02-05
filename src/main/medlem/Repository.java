import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
