/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Medlem;
import DTO.Bokning;
import DTO.Person;
import Repo.RepositoryAdmin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudiastenberg
 */
public class ControllerReception {
    
    RepositoryAdmin rn = new RepositoryAdmin();
    
    public boolean matchMedlemsID(int ID) throws SQLException {
        boolean finns = false;
        Person person = null;
        int id = 0;
        List<Person> personer = new ArrayList<>();

        person = rn.getPersonByMedlemId(id);

        if(person != null)
            finns = true;

        return finns;
    }
    
    
}
