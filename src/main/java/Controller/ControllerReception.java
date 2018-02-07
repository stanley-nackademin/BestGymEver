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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudiastenberg
 */
//public class ControllerReception {
//    
//    RepositoryAdmin rn = new RepositoryAdmin();
//    
//    public boolean matchBokning(int PassId, int MedlemsId) throws SQLException {
//        boolean finns = false;
//        Pass pass = null;
//        Medlem medlem = null;
//        
//        int id = 0;
//        List<Bokning> bokningar = new ArrayList<>();
//
//        bokningar = rn.get
//        
//        person = rn.getPersonByMedlemId(id);
//
//        if(person != null)
//            finns = true;
//
//        return finns;
//    }
//    
//    
//
//public boolean matchAnstalldUsername(String name) throws SQLException {
//        boolean finns = false;
//        Anstalld anstalld = null;
//        int id = 0;
//        List<Anstalld> personal = new ArrayList<>();
//
//        personal = ra.getAllAnstallda();
//        anstalld = personal.stream().filter(c -> c.getaNamn().equalsIgnoreCase(name)).findFirst().orElse(null);
//
//        if(anstalld != null)
//            finns = true;
//
//        return finns;
//    }
//}