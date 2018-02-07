package Repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class RepositoryAnstalld {

    Properties p = new Properties();

    public RepositoryAnstalld() {
        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    protected List<>

}
