/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo;

import DTO.Bokning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudiastenberg
 */
//public class RepositoryReception {
//          
//    public List <Bokning>getBokningByID(int medlem_id, int pass_id){
//        List <Bokning> bokning = new ArrayList<>(); 
//        String query = "Select Medlem_id, Pass_id from Bokning";
//        
//        try (
//                  Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
//                         p.getProperty("name"),
//                         p.getProperty("password"));
//         Statement stmt = con1.createStatement();
//         ResultSet rs = stmt.executeQuery(query);){
//
//        while (rs.next()){
//            int id = rs.getInt("id");
//            //getPersonByMedlemId(id);
//            int passID = rs.getInt("passId");
//            //bokning.add(new Bokning(id,passID)));
//        }
//        
//        //IF medlem id and pass id finns 
//        //checka in person
//    
//    }   catch (SQLException ex) {
//            Logger.getLogger(RepositoryAdmin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//}
//}
