/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Medlem;
import DTO.Bokning;
import DTO.Pass;
import DTO.Person;
import Repo.RepositoryAdmin;
import Repo.RepositoryReception;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudiastenberg
 */
public class ControllerReception {
    
    RepositoryReception rr = new RepositoryReception();
     RepositoryAdmin ra = new RepositoryAdmin();
    
    public boolean MatchPassIdByBokningsId(int passId) throws SQLException {
        boolean finns = false;
        Pass passid = null;
        
        int id = 0;
        List<Pass> p = new ArrayList<>();

        p = (List<Pass>) rr.getPassIdByBokningsId(id);
        
        passid = (Pass) p.get(id); // den måste getID på något sätt. 
       
        if(passid != null)
            finns = true;

        return finns;
    }

    public boolean MatchMedlemIdByBokningsId(int medlemsId) throws SQLException {
        boolean finns = false;
        Medlem medlemsid = null;
        int id = 0;
        List<Medlem> m = new ArrayList<>();
        m = (List<Medlem>) rr.getMedlemIdByBokningsId(id);
        
        medlemsid = m.get(id);

        if(medlemsid != null)
            finns = true;

        return finns;
    }
}