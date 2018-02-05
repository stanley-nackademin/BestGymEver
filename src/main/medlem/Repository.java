import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Repository {
    private String username;
    private String password;
    private String mysqlAddress;

    public Repository() {
        try (FileInputStream settings = new FileInputStream("settings.properties")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
