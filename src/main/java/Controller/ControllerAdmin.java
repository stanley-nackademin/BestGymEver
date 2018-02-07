package Controller;

import DTO.Anstalld;
import DTO.Medlem;
import Repo.RepositoryAdmin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdmin {
    
    RepositoryAdmin ra = new RepositoryAdmin();
    
    public boolean matchUsername(String name) throws SQLException {
        boolean finns = false;
        Medlem medlem = null;
        int id = 0;
        List<Medlem> medlemmar = new ArrayList<>();

        medlemmar = ra.getAllMedlemmar();
            medlem = medlemmar.stream().filter(c -> c.getaNamn().equalsIgnoreCase(name)).findFirst().orElse(null);

        if(medlem != null)
            finns = true;

        return finns;
    }
    
    public boolean matchAnstalldUsername(String name) throws SQLException {
        boolean finns = false;
        Anstalld anstalld = null;
        int id = 0;
        List<Anstalld> personal = new ArrayList<>();

        
        personal = ra.getAllAnstallda();
        anstalld = personal.stream().filter(c -> c.getaNamn().equalsIgnoreCase(name)).findFirst().orElse(null);

        if(anstalld != null)
            finns = true;

        return finns;
    }
    
}
